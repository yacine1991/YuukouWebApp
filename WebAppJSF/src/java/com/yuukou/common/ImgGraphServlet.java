/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import jax.webservice.server.ImageTransfered;
import jax.webservice.server.YuukouServerService;
/**
 *
 * @author thierry
 */
@WebServlet(name = "ImgGraphServlet", urlPatterns = {"/ImgGraphServlet"})
public class ImgGraphServlet extends HttpServlet {
 @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/yuukou-ws.wmin.ac.uk_8181/YuukouServerService/YuukouServerService.wsdl")
    private YuukouServerService service;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImgGraphServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImgGraphServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        
        // Get the value of a request parameter; the name is case-sensitive
    String timeStartname = "timeStart";
    String timeStart = request.getParameter(timeStartname);
    if (timeStart == null) 
    {
    } else if ("".equals(timeStart)) 
    {
    }
        
    String timeEndname = "timeEnd";
    String timeEnd = request.getParameter(timeEndname);
    if (timeEnd == null) 
     {
     } else if ("".equals(timeEnd)) 
     {
     }
    
    String resourcename = "resource";
    String resource = request.getParameter(resourcename);
    if (resource == null) 
     {
     } else if ("".equals(resource)) 
     {
     }
    
        ImageTransfered imgt = null;
       
          //  String timeStart = "2012-03-16 00:00:00";
          //  String timeEnd = "2012-03-24 00:00:00";
            String rqt = "select start_time_session from yuukou_last"
                    + " where start_time_session >= '" + timeStart + "'"
                    + " and start_time_session <= '" + timeEnd + "'"
                    + " and id_resource LIKE '" + resource + "%'" 
                    + " order by start_time_session;";
            int factor = 86400;

            imgt = getGraphWithRequest(rqt, "start_time_session",
                    "Logged-in users", timeStart, timeEnd, factor);
 
        ServletOutputStream out = null;
        response.setContentType("image/png");
        response.setContentLength((imgt.getContents()).length );
        out = response.getOutputStream();
        
        ByteArrayInputStream bin = new ByteArrayInputStream(imgt.getContents());
        BufferedInputStream in = new BufferedInputStream(bin); 
          
        byte[]  buf   = new byte[1024];
        int     count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        
        out.flush();
        out.close();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Image Get Graph Servlet";
    }// </editor-fold>
     private ImageTransfered getGraphWithRequest(java.lang.String rqt, java.lang.String rqtLqbel, java.lang.String label, java.lang.String startTime, java.lang.String endTime, int factor) {
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.getGraphWithRequest(rqt, rqtLqbel, label, startTime, endTime, factor);
    }
}
