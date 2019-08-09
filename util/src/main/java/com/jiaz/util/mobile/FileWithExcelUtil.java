package com.jiaz.util.mobile;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.fastjson.JSONObject;
import com.jiaz.util.mobileDecrypt.MobileAesUtil;
import com.jiaz.util.util.HttpClientResult;
import com.jiaz.util.util.PhoneDataFromK870ApiUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class FileWithExcelUtil {
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, OutputStream outputStream) {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, outputStream, exportParams);

    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, OutputStream outputStream) {
        defaultExport(list, pojoClass, fileName, outputStream, new ExportParams(title, sheetName));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, OutputStream outputStream) {
        defaultExport(list, fileName, outputStream);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, OutputStream outputStream, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) ;
        downLoadExcel(fileName, outputStream, workbook);
    }

    private static void downLoadExcel(String fileName, OutputStream outputStream, Workbook workbook) {
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
        }
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, OutputStream outputStream) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) ;
        downLoadExcel(fileName, outputStream, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    public static <T> List<T> importExcel(InputStream inputstream, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (inputstream == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(inputstream, pojoClass, params);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        String fileName = "zhanzhuyun.xlsx";
        File file = new File("source" + File.separator + fileName);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<UserVo> list = importExcel(inputStream, 0, 1, UserVo.class);
        List<TargetUserVo> targetUserVoList = new ArrayList<>();
        for (UserVo userVo : list) {
            if (StringUtils.isEmpty(userVo.getMobile())) {
                continue;
            }
            String mobile = null;
            try {
                mobile = MobileAesUtil.descrypt(userVo.getMobile());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("手机号解析错误");
                continue;
            }
            if (mobile.length() != 11) {
                System.out.println("手机号不是11位");
                continue;
            }
            TargetUserVo targetUserVo = new TargetUserVo();
            targetUserVo.setMobile(mobile);
            targetUserVo.setRealName(userVo.getRealName());
            targetUserVo.setRegisterTime(userVo.getRegisterTime());
            targetUserVo.setLastLoginTime(userVo.getLastLoginTime());
            HttpClientResult result;
            try {
                result = PhoneDataFromK870ApiUtil.getPhneData(mobile);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("接口api错误");
                continue;
            }
            PhoneVo phoneVo = JSONObject.parseObject(result.getContent(), PhoneVo.class);
            if (phoneVo.getSuccess().equals("1")) {
                targetUserVo.setMerchant(phoneVo.getPhoneResultVo().getOperators());
                String city = phoneVo.getPhoneResultVo().getStyleCitym();
                if (StringUtils.isNotBlank(city)) {
                    String[] cityArray = city.split(",");
                    if (cityArray.length == 3) {
                        targetUserVo.setProvince(cityArray[1]);
                        targetUserVo.setCity(cityArray[2]);
                    }
                }
            }
            targetUserVoList.add(targetUserVo);
        }
        try {
            inputStream.close();//关闭
            File outFile = new File("C:" + File.separator + "Users" + File.separator + "jdd" + File.separator + "Desktop" + File.separator + "target" + File.separator + fileName);
            OutputStream outputStream = new FileOutputStream(outFile);
            exportExcel(targetUserVoList, "", "sheet1", TargetUserVo.class, fileName, outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
