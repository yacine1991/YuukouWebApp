
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

    private final static QName _IsCycleRunning_QNAME = new QName("http://server.webservice.jax/", "isCycleRunning");
    private final static QName _GetRoomsTypeResponse_QNAME = new QName("http://server.webservice.jax/", "getRoomsTypeResponse");
    private final static QName _WhoResponse_QNAME = new QName("http://server.webservice.jax/", "whoResponse");
    private final static QName _SearchHistoryUserResponse_QNAME = new QName("http://server.webservice.jax/", "searchHistoryUserResponse");
    private final static QName _HealthResourcesReportForAllRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForAllRoomsResponse");
    private final static QName _LaunchCycle_QNAME = new QName("http://server.webservice.jax/", "launchCycle");
    private final static QName _GetSitesInformationResponse_QNAME = new QName("http://server.webservice.jax/", "getSitesInformationResponse");
    private final static QName _GetGraphWithRequest_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequest");
    private final static QName _EndMaintenance_QNAME = new QName("http://server.webservice.jax/", "endMaintenance");
    private final static QName _SearchHistoryUser_QNAME = new QName("http://server.webservice.jax/", "searchHistoryUser");
    private final static QName _HealthForAllRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "healthForAllRoomsResponse");
    private final static QName _HealthResourcesReportForAllRooms_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForAllRooms");
    private final static QName _LastResponse_QNAME = new QName("http://server.webservice.jax/", "lastResponse");
    private final static QName _GetListRoomsResponse_QNAME = new QName("http://server.webservice.jax/", "getListRoomsResponse");
    private final static QName _HealthResourcesReportForRoom_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForRoom");
    private final static QName _AskMaintenanceResponse_QNAME = new QName("http://server.webservice.jax/", "askMaintenanceResponse");
    private final static QName _HealthForRoom_QNAME = new QName("http://server.webservice.jax/", "healthForRoom");
    private final static QName _EndMaintenanceResponse_QNAME = new QName("http://server.webservice.jax/", "endMaintenanceResponse");
    private final static QName _GetGraphWithRequestUsingJsonResponse_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequestUsingJsonResponse");
    private final static QName _GetSitesInformation_QNAME = new QName("http://server.webservice.jax/", "getSitesInformation");
    private final static QName _HealthResourcesReportForRoomResponse_QNAME = new QName("http://server.webservice.jax/", "healthResourcesReportForRoomResponse");
    private final static QName _CheckConfigHealth_QNAME = new QName("http://server.webservice.jax/", "checkConfigHealth");
    private final static QName _LastDefaultResponse_QNAME = new QName("http://server.webservice.jax/", "lastDefaultResponse");
    private final static QName _HealthForRoomResponse_QNAME = new QName("http://server.webservice.jax/", "healthForRoomResponse");
    private final static QName _GetGraphWithRequestResponse_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequestResponse");
    private final static QName _GetGraphWithRequestUsingJson_QNAME = new QName("http://server.webservice.jax/", "getGraphWithRequestUsingJson");
    private final static QName _CheckConfigHealthResponse_QNAME = new QName("http://server.webservice.jax/", "checkConfigHealthResponse");
    private final static QName _LastDefault_QNAME = new QName("http://server.webservice.jax/", "lastDefault");
    private final static QName _IsCycleRunningResponse_QNAME = new QName("http://server.webservice.jax/", "isCycleRunningResponse");
    private final static QName _GetRoomsType_QNAME = new QName("http://server.webservice.jax/", "getRoomsType");
    private final static QName _AskMaintenance_QNAME = new QName("http://server.webservice.jax/", "askMaintenance");
    private final static QName _Who_QNAME = new QName("http://server.webservice.jax/", "who");
    private final static QName _HealthForAllRooms_QNAME = new QName("http://server.webservice.jax/", "healthForAllRooms");
    private final static QName _GetListRooms_QNAME = new QName("http://server.webservice.jax/", "getListRooms");
    private final static QName _IsMaintenanceScheduledResponse_QNAME = new QName("http://server.webservice.jax/", "isMaintenanceScheduledResponse");
    private final static QName _IsMaintenanceScheduled_QNAME = new QName("http://server.webservice.jax/", "isMaintenanceScheduled");
    private final static QName _Last_QNAME = new QName("http://server.webservice.jax/", "last");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jax.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsMaintenanceScheduledResponse }
     * 
     */
    public IsMaintenanceScheduledResponse createIsMaintenanceScheduledResponse() {
        return new IsMaintenanceScheduledResponse();
    }

    /**
     * Create an instance of {@link Last }
     * 
     */
    public Last createLast() {
        return new Last();
    }

    /**
     * Create an instance of {@link IsMaintenanceScheduled }
     * 
     */
    public IsMaintenanceScheduled createIsMaintenanceScheduled() {
        return new IsMaintenanceScheduled();
    }

    /**
     * Create an instance of {@link GetRoomsType }
     * 
     */
    public GetRoomsType createGetRoomsType() {
        return new GetRoomsType();
    }

    /**
     * Create an instance of {@link IsCycleRunningResponse }
     * 
     */
    public IsCycleRunningResponse createIsCycleRunningResponse() {
        return new IsCycleRunningResponse();
    }

    /**
     * Create an instance of {@link LastDefault }
     * 
     */
    public LastDefault createLastDefault() {
        return new LastDefault();
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
     * Create an instance of {@link AskMaintenance }
     * 
     */
    public AskMaintenance createAskMaintenance() {
        return new AskMaintenance();
    }

    /**
     * Create an instance of {@link HealthForRoomResponse }
     * 
     */
    public HealthForRoomResponse createHealthForRoomResponse() {
        return new HealthForRoomResponse();
    }

    /**
     * Create an instance of {@link LastDefaultResponse }
     * 
     */
    public LastDefaultResponse createLastDefaultResponse() {
        return new LastDefaultResponse();
    }

    /**
     * Create an instance of {@link GetGraphWithRequestUsingJson }
     * 
     */
    public GetGraphWithRequestUsingJson createGetGraphWithRequestUsingJson() {
        return new GetGraphWithRequestUsingJson();
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
     * Create an instance of {@link GetGraphWithRequestUsingJsonResponse }
     * 
     */
    public GetGraphWithRequestUsingJsonResponse createGetGraphWithRequestUsingJsonResponse() {
        return new GetGraphWithRequestUsingJsonResponse();
    }

    /**
     * Create an instance of {@link CheckConfigHealth }
     * 
     */
    public CheckConfigHealth createCheckConfigHealth() {
        return new CheckConfigHealth();
    }

    /**
     * Create an instance of {@link GetSitesInformation }
     * 
     */
    public GetSitesInformation createGetSitesInformation() {
        return new GetSitesInformation();
    }

    /**
     * Create an instance of {@link HealthResourcesReportForRoomResponse }
     * 
     */
    public HealthResourcesReportForRoomResponse createHealthResourcesReportForRoomResponse() {
        return new HealthResourcesReportForRoomResponse();
    }

    /**
     * Create an instance of {@link HealthForRoom }
     * 
     */
    public HealthForRoom createHealthForRoom() {
        return new HealthForRoom();
    }

    /**
     * Create an instance of {@link AskMaintenanceResponse }
     * 
     */
    public AskMaintenanceResponse createAskMaintenanceResponse() {
        return new AskMaintenanceResponse();
    }

    /**
     * Create an instance of {@link EndMaintenanceResponse }
     * 
     */
    public EndMaintenanceResponse createEndMaintenanceResponse() {
        return new EndMaintenanceResponse();
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
     * Create an instance of {@link GetSitesInformationResponse }
     * 
     */
    public GetSitesInformationResponse createGetSitesInformationResponse() {
        return new GetSitesInformationResponse();
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
     * Create an instance of {@link EndMaintenance }
     * 
     */
    public EndMaintenance createEndMaintenance() {
        return new EndMaintenance();
    }

    /**
     * Create an instance of {@link WhoResponse }
     * 
     */
    public WhoResponse createWhoResponse() {
        return new WhoResponse();
    }

    /**
     * Create an instance of {@link GetRoomsTypeResponse }
     * 
     */
    public GetRoomsTypeResponse createGetRoomsTypeResponse() {
        return new GetRoomsTypeResponse();
    }

    /**
     * Create an instance of {@link IsCycleRunning }
     * 
     */
    public IsCycleRunning createIsCycleRunning() {
        return new IsCycleRunning();
    }

    /**
     * Create an instance of {@link SearchHistoryUserResponse }
     * 
     */
    public SearchHistoryUserResponse createSearchHistoryUserResponse() {
        return new SearchHistoryUserResponse();
    }

    /**
     * Create an instance of {@link ImageTransfered }
     * 
     */
    public ImageTransfered createImageTransfered() {
        return new ImageTransfered();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsCycleRunning }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "isCycleRunning")
    public JAXBElement<IsCycleRunning> createIsCycleRunning(IsCycleRunning value) {
        return new JAXBElement<IsCycleRunning>(_IsCycleRunning_QNAME, IsCycleRunning.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomsTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getRoomsTypeResponse")
    public JAXBElement<GetRoomsTypeResponse> createGetRoomsTypeResponse(GetRoomsTypeResponse value) {
        return new JAXBElement<GetRoomsTypeResponse>(_GetRoomsTypeResponse_QNAME, GetRoomsTypeResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHistoryUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "searchHistoryUserResponse")
    public JAXBElement<SearchHistoryUserResponse> createSearchHistoryUserResponse(SearchHistoryUserResponse value) {
        return new JAXBElement<SearchHistoryUserResponse>(_SearchHistoryUserResponse_QNAME, SearchHistoryUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSitesInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getSitesInformationResponse")
    public JAXBElement<GetSitesInformationResponse> createGetSitesInformationResponse(GetSitesInformationResponse value) {
        return new JAXBElement<GetSitesInformationResponse>(_GetSitesInformationResponse_QNAME, GetSitesInformationResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EndMaintenance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "endMaintenance")
    public JAXBElement<EndMaintenance> createEndMaintenance(EndMaintenance value) {
        return new JAXBElement<EndMaintenance>(_EndMaintenance_QNAME, EndMaintenance.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListRoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getListRoomsResponse")
    public JAXBElement<GetListRoomsResponse> createGetListRoomsResponse(GetListRoomsResponse value) {
        return new JAXBElement<GetListRoomsResponse>(_GetListRoomsResponse_QNAME, GetListRoomsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AskMaintenanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "askMaintenanceResponse")
    public JAXBElement<AskMaintenanceResponse> createAskMaintenanceResponse(AskMaintenanceResponse value) {
        return new JAXBElement<AskMaintenanceResponse>(_AskMaintenanceResponse_QNAME, AskMaintenanceResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EndMaintenanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "endMaintenanceResponse")
    public JAXBElement<EndMaintenanceResponse> createEndMaintenanceResponse(EndMaintenanceResponse value) {
        return new JAXBElement<EndMaintenanceResponse>(_EndMaintenanceResponse_QNAME, EndMaintenanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraphWithRequestUsingJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getGraphWithRequestUsingJsonResponse")
    public JAXBElement<GetGraphWithRequestUsingJsonResponse> createGetGraphWithRequestUsingJsonResponse(GetGraphWithRequestUsingJsonResponse value) {
        return new JAXBElement<GetGraphWithRequestUsingJsonResponse>(_GetGraphWithRequestUsingJsonResponse_QNAME, GetGraphWithRequestUsingJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSitesInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getSitesInformation")
    public JAXBElement<GetSitesInformation> createGetSitesInformation(GetSitesInformation value) {
        return new JAXBElement<GetSitesInformation>(_GetSitesInformation_QNAME, GetSitesInformation.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckConfigHealth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "checkConfigHealth")
    public JAXBElement<CheckConfigHealth> createCheckConfigHealth(CheckConfigHealth value) {
        return new JAXBElement<CheckConfigHealth>(_CheckConfigHealth_QNAME, CheckConfigHealth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastDefaultResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "lastDefaultResponse")
    public JAXBElement<LastDefaultResponse> createLastDefaultResponse(LastDefaultResponse value) {
        return new JAXBElement<LastDefaultResponse>(_LastDefaultResponse_QNAME, LastDefaultResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGraphWithRequestUsingJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getGraphWithRequestUsingJson")
    public JAXBElement<GetGraphWithRequestUsingJson> createGetGraphWithRequestUsingJson(GetGraphWithRequestUsingJson value) {
        return new JAXBElement<GetGraphWithRequestUsingJson>(_GetGraphWithRequestUsingJson_QNAME, GetGraphWithRequestUsingJson.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LastDefault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "lastDefault")
    public JAXBElement<LastDefault> createLastDefault(LastDefault value) {
        return new JAXBElement<LastDefault>(_LastDefault_QNAME, LastDefault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsCycleRunningResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "isCycleRunningResponse")
    public JAXBElement<IsCycleRunningResponse> createIsCycleRunningResponse(IsCycleRunningResponse value) {
        return new JAXBElement<IsCycleRunningResponse>(_IsCycleRunningResponse_QNAME, IsCycleRunningResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "getRoomsType")
    public JAXBElement<GetRoomsType> createGetRoomsType(GetRoomsType value) {
        return new JAXBElement<GetRoomsType>(_GetRoomsType_QNAME, GetRoomsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AskMaintenance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "askMaintenance")
    public JAXBElement<AskMaintenance> createAskMaintenance(AskMaintenance value) {
        return new JAXBElement<AskMaintenance>(_AskMaintenance_QNAME, AskMaintenance.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link HealthForAllRooms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "healthForAllRooms")
    public JAXBElement<HealthForAllRooms> createHealthForAllRooms(HealthForAllRooms value) {
        return new JAXBElement<HealthForAllRooms>(_HealthForAllRooms_QNAME, HealthForAllRooms.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link IsMaintenanceScheduledResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "isMaintenanceScheduledResponse")
    public JAXBElement<IsMaintenanceScheduledResponse> createIsMaintenanceScheduledResponse(IsMaintenanceScheduledResponse value) {
        return new JAXBElement<IsMaintenanceScheduledResponse>(_IsMaintenanceScheduledResponse_QNAME, IsMaintenanceScheduledResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsMaintenanceScheduled }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.jax/", name = "isMaintenanceScheduled")
    public JAXBElement<IsMaintenanceScheduled> createIsMaintenanceScheduled(IsMaintenanceScheduled value) {
        return new JAXBElement<IsMaintenanceScheduled>(_IsMaintenanceScheduled_QNAME, IsMaintenanceScheduled.class, null, value);
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
