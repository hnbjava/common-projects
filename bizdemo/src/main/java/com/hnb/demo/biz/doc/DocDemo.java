//package com.hnb.demo.biz.doc;
//
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.core.FileURIResolver;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//import java.io.*;
//
///**
// * @author xiaolu
// * @date 2018/8/27 下午6:35
// */
//public class DocDemo {
//
//    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
//        String fileName1 = "/Users/xiaolu/Downloads/dist/12.docx";
//        String fileName2 = "/Users/xiaolu/Downloads/dist/123.docx";
//        String outPutFile1 = "/Users/xiaolu/Downloads/dist/doc1";
//        String outPutFile2 = "/Users/xiaolu/Downloads/dist/doc2";
//        String outFilePath1 = "/Users/xiaolu/Downloads/dist/doc1.html";
//        String outFilePath2 = "/Users/xiaolu/Downloads/dist/doc2.html";
//        docx2Html(fileName1,outFilePath1,outPutFile1);
//        docx2Html(fileName2,outFilePath2,outPutFile2);
//    }
//
//    public static void docx2Html(String fileName, String outPutFile, String outPutFilePath) throws TransformerException, IOException, ParserConfigurationException {
//        String fileOutName = outPutFile;
//        long startTime = System.currentTimeMillis();
//        XWPFDocument document = new XWPFDocument(new FileInputStream(fileName));
//        XHTMLOptions options = XHTMLOptions.create().indent(4);
//        // 导出图片
//        File imageFolder = new File(outPutFilePath+"/img");
//        options.setExtractor(new FileImageExtractor(imageFolder));
//        // URI resolver
//        options.URIResolver(new FileURIResolver(imageFolder));
//        File outFile = new File(fileOutName);
//        outFile.getParentFile().mkdirs();
//        OutputStream out = new FileOutputStream(outFile);
//        XHTMLConverter.getInstance().convert(document, out, options);
//        System.out.println("Generate " + fileOutName + " with " + (System.currentTimeMillis() - startTime) + " ms.");
//
//    }
//}
