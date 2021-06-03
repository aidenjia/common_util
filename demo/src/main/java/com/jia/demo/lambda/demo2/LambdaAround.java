package com.jia.demo.lambda.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaAround {
    /**
     * 资源处理（例如处理文件或数据库）时一个常见的模式就是打开一个资源，做一些处理，
     * 然后关闭资源。这个设置和清理阶段总是很类似，并且会围绕着执行处理的那些重要代码。这就
     * 是所谓的环绕执行（execute around）模式，如图 3-2 所示。例如，在以下代码中，加粗显示的就
     * 是从一个文件中读取一行所需的模板代码（注意你使用了 Java 7 中的带资源的 try 语句，它已
     * 经简化了代码，因为你不需要显式地关闭资源了）
     * @return
     * @throws IOException
     */
    public String processFile() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile2(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine =
                processFile2((BufferedReader br) -> br.readLine());

        String twoLines =
                processFile2((BufferedReader br) -> br.readLine() + br.readLine());
    }


}
