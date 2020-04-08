//package de.gtarc.chariot.registrationapi.owls;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonParser;
//import de.gtarc.chariot.connectionapi.impl.WebClientConnection;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//public class OWLsUploader {
//
//    private static final String replaceURL = "http://chariot-km.dai-lab.de/ontologies/iot-services/";
//    private static final String owl_url = "http://chariot-main.dai-lab.de:10000/";
//    private static final String httpd_username = "";
//    private static final String httpd_password = "";
//    private static final String fileEnding = ".owls";
//    private static final String prefix = "templates/chariot_service_";
//    private static final String uploadPrefix = "chariot_service_";
//    private static final String uploadPath = "services/";
//    private static OWLsUploader ins;
//    WebClientConnection webClientConnection;
//    private int port = 80;
//    // Maps the
//    private HashMap<String, String> actionsToOWLMap = new HashMap<>();
//    // Flag that indicates if all files are pulled and the component is ready to go
//    private boolean allFilesPulled = false;
//
//    private OWLsUploader() throws IOException {
//        this.webClientConnection = new WebClientConnection();
//        this.webClientConnection.connect();
//        // Start new thread to get all files in parallel
//        new Thread(this::getFiles).start();
//    }
//
//    public static OWLsUploader getInstance() {
//        if (ins == null) {
//            try {
//                ins = new OWLsUploader();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return ins;
//    }
//
//    private void getFiles() {
//        String response = this.webClientConnection.sendByGet(owl_url + "files");
//        this.webClientConnection.disconnect();
//        JsonArray files = new JsonParser().parse(response).getAsJsonArray();
//        files.forEach(jsonElement -> {
//                    String fileName = jsonElement.getAsString();
//                    int prefixPos = fileName.indexOf(prefix);
//                    int endingPos = fileName.indexOf(fileEnding);
//                    if (endingPos == -1 || prefixPos == -1) return;
//
//                    String actionName = fileName.substring(prefixPos + prefix.length(), endingPos);
//                    this.webClientConnection.connect();
//                    String owls = this.webClientConnection.sendByGet(owl_url + fileName);
//                    this.webClientConnection.disconnect();
//
//                    System.out.println("New service owl found: " + actionName + " --> " + fileName);
//
//                    // Put the owls in the map
//                    this.actionsToOWLMap.put(actionName, owls.replaceAll(replaceURL, owl_url));
//                }
//        );
//
//        allFilesPulled = true;
//    }
//
//
//    public boolean uploadOWL(String entityUUID, String action) throws ClassNotFoundException, IOException {
//
//        // Check if the action name is correctly formatted
//        int hashTagPos = action.lastIndexOf('#');
//        if (hashTagPos == -1 && !this.actionsToOWLMap.containsKey(action)) {
//            System.out.println("No owl for " + action + " found ");
//            return false;
//        }
//        // Get the correct action name
//        String actionName = hashTagPos == -1 ? action : action.substring(hashTagPos + 1);
//
//        String owls = this.actionsToOWLMap.get(actionName);
//        if (owls == null) {
//            System.out.println("No owl for " + actionName + " found ");
//            return false;
//        }
////        File owlsFile = new File(uploadPrefix + actionName + "_" + entityUUID + fileEnding);
////        BufferedWriter writer = new BufferedWriter(new FileWriter(owlsFile));
////        writer.write(owls);
//
//        this.webClientConnection.connect();
//        String response = this.webClientConnection.uploadFile(
//                "http://chariot-main.dai-lab.de:10000/upload?path=" + uploadPath,
//                owls,
//                uploadPrefix + actionName + "_" + entityUUID + fileEnding
//
//        );
//        this.webClientConnection.disconnect();
//
//        System.out.println(response);
//
//        if (response.equalsIgnoreCase("nicht cool")) return false;
//
//        return true;
//    }
//}
