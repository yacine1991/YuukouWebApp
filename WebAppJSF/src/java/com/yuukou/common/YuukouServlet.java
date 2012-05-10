/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import com.yuukou.data.TimeTable;
import com.yuukou.data.Location;
import com.yuukou.data.Room;
import com.yuukou.data.UserList;
import com.yuukou.data.Computer;
import com.yuukou.data.LocationList;
import com.yuukou.data.RoomList;
import com.yuukou.data.User;
import com.yuukou.connection.Connection;
import com.yuukou.stats.Graph;
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
    //@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/yuukou2.wmin.ac.uk_8181/YuukouServerService/YuukouServerService.wsdl")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("choice");
        if (type == null || type.isEmpty()) {
        }

        RoomList rl = new RoomList();
        Room r = new Room();
        Graph g = new Graph();
        UserList ul = new UserList();
        User u = new User();
        LocationList locationList = new LocationList();


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
            //graphRequest(g, "2012-04-16 00:00:00", "2012-04-17 00:00:00", "0");
            request.setAttribute("roomList", rl);
        } else if (type.equals("Room")) {
            url = "/roomInfos.jsp";
            String id = request.getParameter("id");
            //r.setLongLocation("Ai ai ai ai");

            roomStatus(r, id);
            getLocation(locationList);
            roomLocation(r, locationList);
            parseWho(ul, r);

            request.setAttribute("userlist", ul);
            request.setAttribute("room", r);

        } else if (type.equals("credits")) {
            url = "/credits.jsp";
            roomsStatus(rl);
            roomLocation(rl);
            //graphRequest(g, "2012-04-16 00:00:00", "2012-04-17 00:00:00", "0");
            request.setAttribute("roomList", rl);
        } else if (type.equals("stattest")) {
            url = "/roomStatisticsAdmin.jsp";
            roomsStatus(rl);
            roomLocation(rl);
            graphRequest(g, "2012-05-01 00:00:00", "2012-05-10 00:00:00", "0");
            request.setAttribute("roomList", rl);
            request.setAttribute("graph", g);
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
                r.setPcTotal(Integer.toString(Integer.parseInt(jso.get("Busy").toString())
                        + Integer.parseInt(jso.get("Available").toString())
                        + Integer.parseInt(jso.get("Down").toString())));
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

    private void roomLocation(Room r, LocationList locationList) {
        String id = r.getIdRoom().split("-")[0];
        if (locationList.contains(id)) {
            Location l = locationList.get(id);
            r.setLocation(l.getId());
            r.setShortLocation(l.getShortLocation());
            r.setLongLocation(l.getLongLocation());
        }
    }

    private void getLocation(LocationList locationList) {
        JSONParser jp = new JSONParser();
        Object obj;
        Connection c = new Connection();
        String responsegetSitesInformation = c.congetSitesInformations();

        try {
            obj = jp.parse(responsegetSitesInformation);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            JSONArray joo = (JSONArray) jo.get("JSONContents");
            Iterator it = joo.iterator();

            while (it.hasNext()) {
                JSONObject jso = (JSONObject) it.next();

                String id = jso.get("Location").toString();
                String shortL = (String) jso.get("ShortLocation");
                String longL = (String) jso.get("LongLocation");

                locationList.add(id, new Location(id, shortL, longL));
            }
        } else {
            //TODO
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
                healthResourceForRoom(r);
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

    public void healthResourceForRoom(Room r) {
        Connection c = new Connection();
        String responseHealthResourceForRoom = c.healthResourcesReportForRoom(r.getIdRoom());
        JSONParser jp = new JSONParser();
        Object obj = null;

        System.out.println("Rentre dans la fonction heatlhRessource");
        try {
            obj = jp.parse(responseHealthResourceForRoom);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            JSONObject jso = (JSONObject) jo.get("JSONContents");

            if (jso.get("HasContents").toString().equals("YES")) {
                JSONArray joo = (JSONArray) jso.get("Contents");
                Computer[] tabComputer = new Computer[joo.size()];
                String swap4 = (String) jso.get("Room").toString();
                for (int i = 0; i < joo.size(); i++) {
                    JSONObject joComputers = (JSONObject) joo.get(i);

                    String swap1 = (String) joComputers.get("Status").toString();
                    String swap2 = (String) joComputers.get("Resource").toString();
                    String swap3 = (String) joComputers.get("LastTimeSeen").toString();


                    Computer cpt2 = new Computer(swap4, swap2, swap3, swap1);
                    tabComputer[i] = cpt2;
                    r.setHasComputersDown(true);
                }

                r.setComputerList(tabComputer);
            }
        }


    }

    public void parseWho(UserList ul, Room r) {
        JSONParser jp = new JSONParser();
        Object obj;
        int i;
        Connection c = new Connection();
        String responseWho = c.who();


        System.out.println("Rentre dans la fonction Who");
        try {
            obj = jp.parse(responseWho);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {
            ul.setJSONstate("OK");
            ul.setJSONlastCycle(jo.get("JSONLastCycle").toString());
            ul.setJSONmaintenance(jo.get("JSONMaintenance").toString());


            JSONArray joo = (JSONArray) jo.get("JSONContents");
            for (Iterator it = joo.iterator(); it.hasNext();) {
                User u = new User();
                JSONObject jso = (JSONObject) it.next();
                u.setIdUser(jso.get("User").toString());
                u.setResourceUsedByUser(jso.get("Resource").toString());
                u.setStartTimeSession(jso.get("StartTimeSession").toString());
                ul.addUser(u);
                r.setHasUserOnline(true);
            }

        } else {

            ul.setJSONstate("KO");
            ul.setJSONReason(jo.get("JSONReason").toString());
            ul.setJSONmaintenance(responseWho);


        }

        System.out.println("Sort de la fonction Who");
    }

    /*
     * public void searchHistoryUser(String idUser){ JSONParser jp = new
     * JSONParser(); Object obj; int i; Connection c = new Connection(); String
     * responseWho = c.searchHistoryUser(idUser, true, true);
     *
     *
     * System.out.println("Rentre dans la fonction SearchHistoryUser"); try {
     * obj = jp.parse(responseWho);
     *
     * } catch (ParseException ex) {
     * Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null,
     * ex); return; } }
     */
    public File convertByteToImage(byte[] tab, String idRoom) throws IOException {

        InputStream in = new ByteArrayInputStream(tab);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        File fi = new File(getServletContext().getRealPath("/") + "/images/" + idRoom + ".jpg");

        ImageIO.write(bImageFromConvert, "jpg", fi);

        return fi;
    }

    public void graphRequest(Graph g, String timeStart, String timeEnd, String factorStr) {
        Connection c = new Connection();
        String rqt = "select start_time_session from yuukou_last where start_time_session >= '" + timeStart + "' and start_time_session <= '" + timeEnd + "' order by start_time_session;";
        int factor = Integer.parseInt(factorStr);
        System.out.println("Rentre dans la fonction graph");
        JSONParser jp = new JSONParser();
        Object obj;
        int i;

        String responseGetGraph = c.getGraphWithRequestUsingJson(rqt, "start_time_session", "label", timeStart, timeEnd, factor);
        System.out.println(responseGetGraph);
        System.out.println("Aavant TRY");
        try {
            obj = jp.parse(responseGetGraph);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null,
                    ex);
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

            System.out.println("Size content 1 : " + joo.size());
            String[] tabContentsValues = new String[joo.size()];
            System.out.println("Size content 2: " + joo.size());
            for (i = 0; i < joo.size(); i++) {
                tabContentsValues[i] = (String) joo.get(i).toString();
            }
            g.setContentsValues(tabContentsValues);


            JSONArray joo2 = (JSONArray) jso.get("ContentsDates");
            String[] tabContentsDates = new String[joo2.size()];
            for (i = 0; i < joo2.size();
                    i++) {
                tabContentsDates[i] = (String) joo2.get(i).toString();
            }
            g.setContentsDates(tabContentsDates);

            JSONArray joo3 = (JSONArray) jso.get("Image");
            String[] tabImages = new String[joo3.size()];
            for (i = 0; i < joo2.size(); i++) {
                tabImages[i] =
                        (String) joo3.get(i).toString();
            }
            g.setImage(tabImages);


        } else {
            g.setJSONstate("KO");
            g.setJSONReason(jo.get("JSONReason").toString());
        }
    }
}
