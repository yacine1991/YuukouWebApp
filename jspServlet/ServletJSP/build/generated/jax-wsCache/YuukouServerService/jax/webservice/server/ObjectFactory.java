
package jax.webservice.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jax.webservice.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckTimeTablesDatabase_QNAME = new QName("http://server.webservice.jax/", "checkTimeTablesDatabase");
    private final static QName _CheckTimeTablesDatabaseResponse_QNAME = new QName("http://server.webservice.jax/", "checkTimeTablesDatabaseResponse");
    private final static QName _WhoResponse_QNAME = new QName("http://server.webservice.jax/", "whoResponse");
    private final static QName _HealthResourcesReportForRoomResponse_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForRoomResponse");
    private final static QName _SearchHistoryUserResponse_QNAME = new QName("http://server.webservice.jax/", "searchHistoryUserResponse");
    private final static QName _CheckConfigHealth_QNAME = new QName("http://server.webservice.jax/", "checkConfigHealth");
    private final static QName _HealthResourcesReportForAllRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForAllRoomsResponse");
    private final static QName _LaunchCycle_QNAME = new QName("http://server.webservice.jax/", "launchCycle");
    private final static QName _GetGraphWithRequest_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequest");
    private final static QName _HealthForRoomResponse_QNAME = new QName("http://server.webservice.jax/", "healthForRoomResponse");
    private final static QName _GetGraphWithRequestResponse_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequestResponse");
    private final static QName _CheckConfigHealthResponse_QNAME = new QName("http://server.webservice.jax/", "checkConfigHealthResponse");
    private final static QName _SearchHistoryUser_QNAME = new QName("http://server.webservice.jax/", "searchHistoryUser");
    private final static QName _HealthForAllRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "healthForAllRoomsResponse");
    private final static QName _HealthResourcesReportForAllRooms_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForAllRooms");
    private final static QName _LastResponse_QNAME = new QName("http://server.webservice.jax/", "lastResponse");
    private final static QName _Who_QNAME = new QName("http://server.webservice.jax/", "who");
    private final static QName _GetListRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "getListRoomsResponse");
    private final static QName _HealthForAllRooms_QNAME = new QName("http://server.webservice.jax/", "healthForAllRooms");
    private final static QName _HealthResourcesReportForRoom_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForRoom");
    private final static QName _GetListRooms_QNAME = new QName("http://server.webservice.jax/", "getListRooms");
    private final static QName _HealthForRoom_QNAME = new QName("http://server.webservice.jax/", "healthForRoom");
    private final static QName _Last_QNAME = new QName("http://server.webservice.jax/", "last");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jax.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HealthForRoom }
     * 
     */
    public HealthForRoom createHealthForRoom() {
        return new HealthForRoom();
    }

    /**
     * Create an instance of {@link Last }
     * 
     */
    public Last createLast() {
        return new Last();
    }

    /**
     * Create an instance of {@link LastResponse }
     * 
     */
    public LastResponse createLastResponse() {
        return new LastResponse();
    }

    /**
     * Create an instance of {@link HealthForAllRoomsResponse }
     * 
     */
    public HealthForAllRoomsResponse createHealthForAllRoomsResponse() {
        return new HealthForAllRoomsResponse();
    }

    /**
     * Create an instance of {@link HealthResourcesReportForAllRooms }
     * 
     */
    public HealthResourcesReportForAllRooms createHealthResourcesReportForAllRooms() {
        return new HealthResourcesReportForAllRooms();
    }

    /**
     * Create an instance of {@link SearchHistoryUser }
     * 
     */
    public SearchHistoryUser createSearchHistoryUser() {
        return new SearchHistoryUser();
    }

    /**
     * Create an instance of {@link HealthResourcesReportForRoom }
     * 
     */
    public HealthResourcesReportForRoom createHealthResourcesReportForRoom() {
        return new HealthResourcesReportForRoom();
    }

    /**
     * Create an instance of {@link GetListRooms }
     * 
     */
    public GetListRooms createGetListRooms() {
        return new GetListRooms();
    }

    /**
     * Create an instance of {@link HealthForAllRooms }
     * 
     */
    public HealthForAllRooms createHealthForAllRooms() {
        return new HealthForAllRooms();
    }

    /**
     * Create an instance of {@link Who }
     * 
     */
    public Who createWho() {
        return new Who();
    }

    /**
     * Create an instance of {@link GetListRoomsResponse }
     * 
     */
    public GetListRoomsResponse createGetListRoomsResponse() {
        return new GetListRoomsResponse();
    }

    /**
     * Create an instance of {@link GetGraphWithRequest }
     * 
     */
    public GetGraphWithRequest createGetGraphWithRequest() {
        return new GetGraphWithRequest();
    }

    /**
     * Create an instance of {@link HealthForRoomResponse }
     * 
     */
    public HealthForRoomResponse createHealthForRoomResponse() {
        return new HealthForRoomResponse();
    }

    /**
     * Create an instance of {@link LaunchCycle }
     * 
     */
    public LaunchCycle createLaunchCycle() {
        return new LaunchCycle();
    }

    /**
     * Create an instance of {@link HealthResourcesReportForAllRoomsResponse }
     * 
     */
    public HealthResourcesReportForAllRoomsResponse createHealthResourcesReportForAllRoomsResponse() {
        return new HealthResourcesReportForAllRoomsResponse();
    }

    /**
     * Create an instance of {@link CheckConfigHealthResponse }
     * 
     */
    public CheckConfigHealthResponse createCheckConfigHealthResponse() {
        return new CheckConfigHealthResponse();
    }

    /**
     * Create an instance of {@link GetGraphWithRequestResponse }
     * 
     */
    public GetGraphWithRequestResponse createGetGraphWithRequestResponse() {
        return new GetGraphWithRequestResponse();
    }

    /**
     * Create an instance of {@link WhoResponse }
     * 
     */
    public WhoResponse createWhoResponse() {
        return new WhoResponse();
    }

    /**
     * Create an instance of {@link CheckTimeTablesDatabaseResponse }
     * 
     */
    public CheckTimeTablesDatabaseResponse createCheckTimeTablesDatabaseResponse() {
        return new CheckTimeTablesDatabaseResponse();
    }

    /**
     * Create an instance of {@link CheckTimeTablesDatabase }
     * 
     */
    public CheckTimeTablesDatabase createCheckTimeTablesDatabase() {
        return new CheckTimeTablesDatabase();
    }

    /**
     * Create an instance of {@link CheckConfigHealth }
     * 
     */
    public CheckConfigHealth createCheckConfigHealth() {
        return new CheckConfigHealth();
    }

    /**
     * Create an instance of {@link SearchHistoryUserResponse }
     * 
     */
    public SearchHistoryUserResponse createSearchHistoryUserResponse() {
        return new SearchHistoryUserResponse();
    }

    /**
     * Create an instance of {@link HealthResourcesReportForRoomResponse }
     * 
     */
    public HealthResourcesReportForRoomResponse createHealthResourcesReportForRoomResponse() {
        return new HealthResourcesReportForRoomResponse();
    }

    /**
     * Create an instance of {@link ImageTransfered }
     * 
     */
    public ImageTransfered createImageTransfered() {
        return new ImageTransfered();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTimeTablesDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "checkTimeTablesDatabase")
    public JAXBElement<CheckTimeTablesDatabase> createCheckTimeTablesDatabase(CheckTimeTablesDatabase value) {
        return new JAXBElement<CheckTimeTablesDatabase>(_CheckTimeTablesDatabase_QNAME, CheckTimeTablesDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTimeTablesDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "checkTimeTablesDatabaseResponse")
    public JAXBElement<CheckTimeTablesDatabaseResponse> createCheckTimeTablesDatabaseResponse(CheckTimeTablesDatabaseResponse value) {
        return new JAXBElement<CheckTimeTablesDatabaseResponse>(_CheckTimeTablesDatabaseResponse_QNAME, CheckTimeTablesDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WhoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "whoResponse")
    public JAXBElement<WhoResponse> createWhoResponse(WhoResponse value) {
        return new JAXBElement<WhoResponse>(_WhoResponse_QNAME, WhoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthResourcesReportForRoomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthResourcesReportForRoomResponse")
    public JAXBElement<HealthResourcesReportForRoomResponse> createHealthResourcesReportForRoomResponse(HealthResourcesReportForRoomResponse value) {
        return new JAXBElement<HealthResourcesReportForRoomResponse>(_HealthResourcesReportForRoomResponse_QNAME, HealthResourcesReportForRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHistoryUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "searchHistoryUserResponse")
    public JAXBElement<SearchHistoryUserResponse> createSearchHistoryUserResponse(SearchHistoryUserResponse value) {
        return new JAXBElement<SearchHistoryUserResponse>(_SearchHistoryUserResponse_QNAME, SearchHistoryUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckConfigHealth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "checkConfigHealth")
    public JAXBElement<CheckConfigHealth> createCheckConfigHealth(CheckConfigHealth value) {
        return new JAXBElement<CheckConfigHealth>(_CheckConfigHealth_QNAME, CheckConfigHealth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthResourcesReportForAllRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthResourcesReportForAllRoomsResponse")
    public JAXBElement<HealthResourcesReportForAllRoomsResponse> createHealthResourcesReportForAllRoomsResponse(HealthResourcesReportForAllRoomsResponse value) {
        return new JAXBElement<HealthResourcesReportForAllRoomsResponse>(_HealthResourcesReportForAllRoomsResponse_QNAME, HealthResourcesReportForAllRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LaunchCycle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "launchCycle")
    public JAXBElement<LaunchCycle> createLaunchCycle(LaunchCycle value) {
        return new JAXBElement<LaunchCycle>(_LaunchCycle_QNAME, LaunchCycle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraphWithRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getGraphWithRequest")
    public JAXBElement<GetGraphWithRequest> createGetGraphWithRequest(GetGraphWithRequest value) {
        return new JAXBElement<GetGraphWithRequest>(_GetGraphWithRequest_QNAME, GetGraphWithRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthForRoomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthForRoomResponse")
    public JAXBElement<HealthForRoomResponse> createHealthForRoomResponse(HealthForRoomResponse value) {
        return new JAXBElement<HealthForRoomResponse>(_HealthForRoomResponse_QNAME, HealthForRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraphWithRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getGraphWithRequestResponse")
    public JAXBElement<GetGraphWithRequestResponse> createGetGraphWithRequestResponse(GetGraphWithRequestResponse value) {
        return new JAXBElement<GetGraphWithRequestResponse>(_GetGraphWithRequestResponse_QNAME, GetGraphWithRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckConfigHealthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "checkConfigHealthResponse")
    public JAXBElement<CheckConfigHealthResponse> createCheckConfigHealthResponse(CheckConfigHealthResponse value) {
        return new JAXBElement<CheckConfigHealthResponse>(_CheckConfigHealthResponse_QNAME, CheckConfigHealthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHistoryUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "searchHistoryUser")
    public JAXBElement<SearchHistoryUser> createSearchHistoryUser(SearchHistoryUser value) {
        return new JAXBElement<SearchHistoryUser>(_SearchHistoryUser_QNAME, SearchHistoryUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthForAllRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthForAllRoomsResponse")
    public JAXBElement<HealthForAllRoomsResponse> createHealthForAllRoomsResponse(HealthForAllRoomsResponse value) {
        return new JAXBElement<HealthForAllRoomsResponse>(_HealthForAllRoomsResponse_QNAME, HealthForAllRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthResourcesReportForAllRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthResourcesReportForAllRooms")
    public JAXBElement<HealthResourcesReportForAllRooms> createHealthResourcesReportForAllRooms(HealthResourcesReportForAllRooms value) {
        return new JAXBElement<HealthResourcesReportForAllRooms>(_HealthResourcesReportForAllRooms_QNAME, HealthResourcesReportForAllRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "lastResponse")
    public JAXBElement<LastResponse> createLastResponse(LastResponse value) {
        return new JAXBElement<LastResponse>(_LastResponse_QNAME, LastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Who }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "who")
    public JAXBElement<Who> createWho(Who value) {
        return new JAXBElement<Who>(_Who_QNAME, Who.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getListRoomsResponse")
    public JAXBElement<GetListRoomsResponse> createGetListRoomsResponse(GetListRoomsResponse value) {
        return new JAXBElement<GetListRoomsResponse>(_GetListRoomsResponse_QNAME, GetListRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthForAllRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthForAllRooms")
    public JAXBElement<HealthForAllRooms> createHealthForAllRooms(HealthForAllRooms value) {
        return new JAXBElement<HealthForAllRooms>(_HealthForAllRooms_QNAME, HealthForAllRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthResourcesReportForRoom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthResourcesReportForRoom")
    public JAXBElement<HealthResourcesReportForRoom> createHealthResourcesReportForRoom(HealthResourcesReportForRoom value) {
        return new JAXBElement<HealthResourcesReportForRoom>(_HealthResourcesReportForRoom_QNAME, HealthResourcesReportForRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getListRooms")
    public JAXBElement<GetListRooms> createGetListRooms(GetListRooms value) {
        return new JAXBElement<GetListRooms>(_GetListRooms_QNAME, GetListRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthForRoom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthForRoom")
    public JAXBElement<HealthForRoom> createHealthForRoom(HealthForRoom value) {
        return new JAXBElement<HealthForRoom>(_HealthForRoom_QNAME, HealthForRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Last }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "last")
    public JAXBElement<Last> createLast(Last value) {
        return new JAXBElement<Last>(_Last_QNAME, Last.class, null, value);
    }

}
