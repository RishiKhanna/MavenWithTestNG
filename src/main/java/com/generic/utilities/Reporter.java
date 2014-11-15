package com.generic.utilities;

import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;

public class Reporter {
    private static Writer outputReport = null;
    private static final String[] HEADER = { "Test Case ID", "Test Name and Steps", "Status",
            "Comments" };
    private static final String FOLDERNAME = "./reports/";
    private static final String FILENAME = "test";
    private static final Logger LOGGER = Logg.createLogger();
    private static File file = null;

    private Reporter() {
    }

    static {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        String timeStamp = dateFormat.format(cal.getTime());

        String text = "<html>"
                + "<head>"
                + "      <meta content=text/html; charset=ISO-8859-1 http-equiv=content-type>"
                + "      <title>Selenium Test Report</title>"
                + "      <style type=text/css>"
                + "       .title {  font-family: 'Lobster', Georgia, Times, serif; font-size: 40px;  font-weight: bold; color:#806D7E;}"
                + "          .bold_text {  font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px;  font-weight: bold;}"
                + "           ..normal_text {  font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px;  font-weight: normal;}"
                + "           .small_text {  font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 10px;  font-weight: normal; }"
                + "          .border { border: 1px solid #000000;}"
                + "        .border_left { border-top: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px solid #000000;}"
                + "       .border_right { border-top: 1px solid #045AFD; border-right: 1px solid #000000;}"
                + "       .result_ok { font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px;  font-weight: bold; background-color:green;text-align: center; }"
                + "       .result_nok { font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px;  font-weight: bold;background-color:red; text-align: center; }"
                + "       .overall_ok { font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px; background-color:green; font-weight:bold; text-align: left; }"
                + "       .overall_nok { font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px; background-color:red; font-weight:bold; text-align: left; }"
                + "       .bborder_left { border-top: 1px solid #000000; border-left: 1px solid #000000; border-bottom: 1px solid #000000; background-color:#000000;font-family:Segoe UI; font-size: 12px;  font-weight: bold;text-align: center; color: white;}"
                + "       .bborder_right { border-right: 1px solid #045AFD; background-color:#000000;font-family: 'Adobe Caslon Pro', 'Hoefler Text', Georgia, Garamond, Times, serif; font-size: 12px;  font-weight: bold; text-align: center; color: white;}"

                + "      </style>"
                + "<script src="
                + "http://www.kryogenix.org/code/browser/sorttable/sorttable.js"
                + " type="
                + "text/javascript"
                + "></script>"
                + "<script type="
                + "'text/javascript'"
                + ">"

                + "var rowVisible = true;"

                + "function toggleDisplay(tbl) {"
                + "   tbl.style.display=''"
                + ";"
                + "var tblRows = tbl.rows;"

                + "   for (i = 0; i < tblRows.length; i++) {"
                + "      if (tblRows[i].className != "
                + "'headerRow'"
                + ")"
                + " {"
                + " tblRows[i].style.display = (rowVisible) ? 'none':'' ;"
                + "      }"
                + "   }"
                + "   rowVisible = !rowVisible;"
                + "}"
                + "</script>"
                + "      </head>"
                + "      <body>"
                + "      <br>"
                + "      <center>"
                + "      <table width=95% border=0 cellpadding=2 cellspacing=2>"
                + "      <tbody>"
                + "      <tr>"
                + "      <td>"
                + "      <table width=100% border=0 cellpadding=2 cellspacing=2>"
                + "      <tbody>"
                + "      <tr>"
                + "      <td align=center><p class=title>Selenium Test Report</p></td></tr><tr> <td align=left></img><td align=right><img src="
                + "http://www.citiustech.com/images/logo.gif" + "></img></td></tr>"
                + "      </tbody>" + "      </table>" + "      <br><br>"

                + "      <br><br><br><br> ";

        try {

            file = new File(FOLDERNAME + FILENAME + "-" + timeStamp + ".html");
            outputReport = new BufferedWriter(new FileWriter(file));
            outputReport.write(text);
            addHeader(HEADER);
            outputReport.flush();
            outputReport.close();
            LOGGER.info(Utilities.getCurrentThreadId() + "Generated static part of the report");

        } catch (IOException io) {
            throw new RuntimeException("IOException in the static block of Reporter Class", io);
        } catch (Exception ex) {
            throw new RuntimeException("Exception in the static block of Reporter Class", ex);
        }
    }

    private static void addHeader(String[] arrHeader) throws IOException {
        int colLength = arrHeader.length;
        if (colLength > 0) {
            String reportContent2 = new String();
            reportContent2 = "<table id='results' class='sortable' width:auto cellpadding=2 cellspacing=0 border=1><tr>";
            try {
                int i = 0;
                while (i < arrHeader.length) {
                    if ("".equals(arrHeader[i])) {
                        arrHeader[i] = "-";
                    }
                    reportContent2 = reportContent2 + "<th class=bborder_left>" + arrHeader[i]
                            + "</th>";
                    outputReport.write(reportContent2);
                    reportContent2 = "";
                    i = i + 1;
                }

                outputReport.write("</tr>");

            } catch (IOException io) {
                throw new IOException("IOException in the addHeader() method of Reporter Class", io);
            }
        }
    }

    public static void addData(String[] arrData) throws IOException {
        int colLength = arrData.length;
        try {
            outputReport = new BufferedWriter(new FileWriter(file, true));
            if (colLength > 0) {
                String reportContent2 = new String();
                reportContent2 = "<tr>";
                int i = 0;
                while (i < arrData.length) {

                    if ("".equals(arrData[i])) {
                        arrData[i] = "-";
                    }
                    reportContent2 = reportContent2 + "<td class=normal_text>" + arrData[i]
                            + "</td>";
                    outputReport.write(reportContent2);
                    reportContent2 = "";
                    i = i + 1;
                }
                outputReport.write("</tr>");
            }
            outputReport.flush();
            outputReport.close();
        } catch (IOException io) {
            throw new IOException("IOException in the addData() method of Reporter Class", io);
        }

    }

    public static void closeReport() throws IOException {
        try {
            outputReport.close();
        } catch (IOException io) {
            throw new IOException("IOException in the closeReport() method of Reporter Class", io);
        }
    }
}
