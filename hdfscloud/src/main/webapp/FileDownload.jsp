
    <%@ page import="java.io.OutputStream,java.io.*" %>
    <%@ page import="java.io.FileInputStream,org.apache.hadoop.fs.*" %>
    <%@ page import="java.net.URLEncoder,java.net.URI,org.apache.hadoop.conf.Configuration,org.apache.hadoop.io.IOUtils" %>
    <%@ page language="java" contentType="application/x-msdownload" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        //关于文件下载时采用文件流输出的方式处理：
        String bath = request.getSession().getServletContext().getRealPath("");
        response.setContentType("application/x-download");
        String fileDownloadName = "hdfs://MS-TXY:9002/jps.txt"; // 下载的文件的物理路径＋文件名
        String fileDisplayName = String.valueOf(System.currentTimeMillis())+fileDownloadName.substring(fileDownloadName.lastIndexOf("."),fileDownloadName.length()); // 给用户提供的下载文件名
        fileDisplayName = "newjps.txt";
        response.addHeader("Content-Disposition", "attachment;filename=" + fileDisplayName);
        OutputStream outp = null;
        FSDataInputStream in = null;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create("hdfs://MS-TXY:9002/tmp/jps.txt"), conf);
        try {
            outp = response.getOutputStream();
           // in = new FileInputStream(fileDownloadName);
            in =fs.open(new Path("hdfs://MS-TXY:9002/tmp/jps.txt"));
            IOUtils.copyBytes(in, outp, 4096, false);
            in.seek(0); // go back to the start of the file
            IOUtils.copyBytes(in, System.out, 4096, false);
            } catch (Exception e)
        {
                System.out.println("文件下载失败!");
                e.printStackTrace();
            }finally {
            IOUtils.closeStream(in);
            if (in != null) {
                in.close();
                in = null;
            }
            if (outp != null) {
                outp.close();
                outp = null;
            }
            }
    %>
    
