/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yacine
 */
public class YuukouServlet extends HttpServlet {

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

        String type = request.getParameter("choice");
        if (type == null || type.isEmpty()) {
        }

        RoomList rl = new RoomList();
        Room r = new Room();
        Graph g = new Graph();


        String url = null;

        if (type.equals("find")) {
            url = "/roomsDisplay.jsp";
            roomsStatus(rl);
            roomLocation(rl);
            request.setAttribute("roomList", rl);
        } else if (type.equals("stats")) {
            url = "/roomStatistics.jsp";
            roomsStatus(rl);
            roomLocation(rl);
            graphRequest(g, "2012-04-16 00:00:00", "2012-04-17 00:00:00", "0");
            request.setAttribute("roomList", rl);
        } else if (type.equals("Room")) {
            url = "/roomInfos.jsp";
            String id = request.getParameter("id");
            //r.setLongLocation("Ai ai ai ai");

            roomStatus(r, id);
            roomLocation(rl);
            request.setAttribute("room", r);
            request.setAttribute("roomList", rl);
        }



        ServletContext sc = getServletContext();

        RequestDispatcher rd = sc.getRequestDispatcher(url);

        rd.forward(request, response);


//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet YuukouServlet</title>");
//            out.println("</head>");
//
//            out.println("<body>");
//            out.println("<h1>Servlet YuukouServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//
//        } finally {
//            out.close();
//        }
    }

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


        processRequest(request, response);
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
        return "Short description";
    }

    public void roomsStatus(RoomList rl) throws IOException {
        JSONParser jp = new JSONParser();
        Object obj;
        int i;
        Connection c = new Connection();
        String responsehealthForAllRooms = c.conhealthForAllRooms();


        try {
            obj = jp.parse(responsehealthForAllRooms);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            rl.setJSONstate("OK");
            rl.setJSONlastCycle(jo.get("JSONLastCycle").toString());
            rl.setJSONmaintenance(jo.get("JSONMaintenance").toString());
            JSONArray joo = (JSONArray) jo.get("JSONContents");

            for (Iterator it = joo.iterator(); it.hasNext();) {
                Room r = new Room();
                JSONObject jso = (JSONObject) it.next();
                r.setIdRoom(jso.get("Room").toString());
                r.setStatus(jso.get("State").toString());
                r.setTypeResource(jso.get("TypeResources").toString());

                //a finir ajouter une listRooms pour l'
                r.setHealthRoom(jso.get("Health").toString());
                r.setAvailability(jso.get("Availability").toString());
                r.setPcAvailable(jso.get("Available").toString());
                r.setPcDown(jso.get("Down").toString());
                r.setResources(jso.get("Resources").toString());
                r.setBusy(jso.get("Busy").toString());
                r.setRestriction(jso.get("Restriction").toString());

                /*
                 * if (jso.get("HasImage").equals("YES")) { r.setHasImage(true);
                 *
                 *
                 *
                 * }
                 */

                if (jso.get("State").equals("Busy")) {
                    r.setStartTime(jso.get("StartTime").toString());
                    r.setEndTime(jso.get("EndTime").toString());
                    r.setEventType(jso.get("EventType").toString());
                }
                rl.addRoom(r);

            }

        } else {
            rl.setJSONstate("KO");
            rl.setJSONReason(jo.get("JSONReason").toString());
            rl.setJSONmaintenance(responsehealthForAllRooms);


        }
    }

    public void roomLocation(RoomList rl) {
        JSONParser jp = new JSONParser();
        Object obj;
        Connection c = new Connection();
        String responsegetSitesInformation = c.congetSitesInformations();
        int i = 0;

        try {
            obj = jp.parse(responsegetSitesInformation);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            rl.setJSONstate("OK");
            rl.setJSONlastCycle(jo.get("JSONLastCycle").toString());
            rl.setJSONmaintenance(jo.get("JSONMaintenance").toString());
            JSONArray joo = (JSONArray) jo.get("JSONContents");

            for (i = 0; i < rl.getSize(); i++) {

                Iterator it = joo.iterator();
                boolean loop = false;
                while (it.hasNext() && !loop) {

                    Room r = rl.getRoom2(i);
                    JSONObject jso = (JSONObject) it.next();

                    if (r.getIdRoom().startsWith(jso.get("Location").toString())) {

                        r.setShortLocation(jso.get("ShortLocation").toString());
                        r.setLongLocation(jso.get("LongLocation").toString());
                        System.out.println("Long Location : " + r.getLongLocation());
                        r.setLocation(jso.get("Location").toString());

                        loop = true;
                    }
                }


            }
        } else {

            rl.setJSONstate("KO");
            rl.setJSONReason(jo.get("JSONReason").toString());
            rl.setJSONmaintenance(responsegetSitesInformation);


        }
    }

    public void roomStatus(Room r, String idRoom) throws IOException {
        JSONParser jp = new JSONParser();
        Object obj;
        int i;
        Connection c = new Connection();
        String responsehealthForRoom = c.healthForRoom(idRoom);

        System.out.println("Rentre dans la fonction");
        try {
            obj = jp.parse(responsehealthForRoom);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            r.setJSONstate("OK");
            r.setJSONlastCycle(jo.get("JSONLastCycle").toString());
            r.setJSONmaintenance(jo.get("JSONMaintenance").toString());


            JSONObject jso = (JSONObject) jo.get("JSONContents");
            r.setIdRoom(jso.get("Room").toString());
            r.setStatus(jso.get("State").toString());
            r.setTypeResource(jso.get("TypeResources").toString());

            if (jso.get("State").equals("Available")) {
                //a finir ajouter une listRooms pour l'
                r.setHealthRoom(jso.get("Health").toString());
                r.setAvailability(jso.get("Availability").toString());
                r.setPcAvailable(jso.get("Available").toString());
                r.setPcDown(jso.get("Down").toString());
                r.setResources(jso.get("Resources").toString());
                r.setBusy(jso.get("Busy").toString());
                r.setRoomUrl(jso.get("Url").toString());
                r.setRestriction(jso.get("Restriction").toString());
                System.out.println("Parsage jusqua a hasImage");
            } else {
                if (jso.get("HasTimeTable").equals("YES")) {

                    r.setHasTimeTable(true);

                    JSONArray joo = (JSONArray) jso.get("TimeTable");
                    TimeTable[] tabTimeTable = new TimeTable[joo.size()];

                    for (i = 0; i < joo.size(); i++) {
                        JSONObject joTimeTable = (JSONObject) joo.get(i);
                        String swap1 = (String) joTimeTable.get("StartTime");
                        String swap2 = (String) joTimeTable.get("EndTime");
                        String swap3 = (String) joTimeTable.get("EventType");
                        String swap4 = (String) joTimeTable.get("EventDescription");
                        TimeTable tb = new TimeTable(swap1, swap2, swap3, swap4);

                        tabTimeTable[i] = tb;

                    }
                    r.setTimeTable(tabTimeTable);


                }




            }

            if (jso.get("HasImage").equals("YES")) {
                r.setHasImage(true);
                System.out.println("Has image" + jso.get("HasImage"));


                JSONArray jab = (JSONArray) jso.get("Image");
                byte[] tab = new byte[jab.size()];
                for (i = 0; i < jab.size(); i++) {
                    Long ll = (Long) jab.get(i);
                    String test = String.valueOf(ll);

                    tab[i] = Byte.parseByte(test);
                }

                r.setImage(convertByteToImage(tab, r.getIdRoom()));

                System.out.println("Fin conversion image");
            }




        } else {
            r.setJSONstate("KO");
            r.setJSONReason(jo.get("JSONReason").toString());



        }
        System.out.println("Fin de la focntion roomStatus");
    }

    public File convertByteToImage(byte[] tab, String idRoom) throws IOException {

        InputStream in = new ByteArrayInputStream(tab);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        File fi = new File(getServletContext().getRealPath("/") + "/images/" + idRoom + ".jpg");

        ImageIO.write(bImageFromConvert, "jpg", fi);

        return fi;
    }

    public void graphRequest(Graph g, String timeStart, String timeEnd, String factorStr) {
        Connection c = new Connection();
        String rqt = "select start_time_session from yuukou_last"
                + " where start_time_session >= '" + timeStart + "'"
                + " and start_time_session <= '" + timeEnd + "'"
                + " order by start_time_session;";
        int factor = Integer.parseInt(factorStr);


        JSONParser jp = new JSONParser();
        Object obj;
        int i;

        String responseGetGraph = c.getGraphWithRequestUsingJson(rqt, "start_time_session", "HoHoHOHOHO", timeStart, timeEnd, factor);
        System.out.println(responseGetGraph);

        try {
            obj = jp.parse(responseGetGraph);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            g.setJSONstate("OK");
            g.setJSONlastCycle(jo.get("JSONLastCycle").toString());
            g.setJSONmaintenance(jo.get("JSONMaintenance").toString());


            JSONObject jso = (JSONObject) jo.get("JSONContents");
            g.setHasData(jso.get("HasData").toString());
            g.setImageType(jso.get("ImageType").toString());

            JSONArray joo = (JSONArray) jso.get("ContentsValues");
            System.out.println("Size" + joo.toArray().length);

            String[] tabContentsValues = new String[joo.size()];
            for (i = 0; i < joo.size(); i++) {
                tabContentsValues[i] = (String) joo.get(i).toString();
            }
            g.setContentsValues(tabContentsValues);


            JSONArray joo2 = (JSONArray) jso.get("ContentsDates");
            String[] tabContentsDates = new String[joo2.size()];
            for (i = 0; i < joo2.size(); i++) {
                tabContentsDates[i] = (String) joo2.get(i).toString();
            }
            g.setContentsDates(tabContentsDates);

            JSONArray joo3 = (JSONArray) jso.get("Image");
            String[] tabImages = new String[joo3.size()];
            for (i = 0; i < joo2.size(); i++) {
                tabImages[i] = (String) joo3.get(i).toString();
            }
            g.setImage(tabImages);


        } else {
            g.setJSONstate("KO");
            g.setJSONReason(jo.get("JSONReason").toString());
        }
    }
}
