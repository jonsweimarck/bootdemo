package se.scatteredbits.springboot;

import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.model.Model;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.model.Tags;
import com.structurizr.view.*;

public class StructurizrDocumentation {

    private static final String API_KEY = "05448163-23ee-4968-8450-71e6725fa0b4";
    private static final String API_SECRET = "b57b6e8f-bd56-4234-9785-c456f704cbe2";
    private static final long WORKSPACE_ID = 28871;

    public static void main(String[] args) throws Exception {

        // a Structurizr workspace is the wrapper for a software architecture model, views and documentation
        Workspace workspace = new Workspace(
                "My mooooodel",
                "This is a model of my software system.");
        Model model = workspace.getModel();
        ViewSet viewSet = workspace.getViews();
        Styles styles = viewSet.getConfiguration().getStyles();

        // add some elements to your software architecture model
        Person user = model.addPerson("Useer", "A user of my software system.");
        SoftwareSystem softwareSystem = model.addSoftwareSystem("Software System", "My software system.");
        user.uses(softwareSystem, "Usess");

        // define some views (the diagrams you would like to see)
        SystemContextView contextView = viewSet.createSystemContextView(softwareSystem, "Context", "A description of this diagram.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        contextView.setPaperSize(PaperSize.A5_Landscape);

        // optionally, add some styling
        styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).shape(Shape.Person);

        uploadWorkspaceToStructurizr(workspace);
    }


    private static void uploadWorkspaceToStructurizr(Workspace workspace) throws Exception {
        StructurizrClient structurizrClient = new StructurizrClient(API_KEY, API_SECRET);
        structurizrClient.putWorkspace(WORKSPACE_ID, workspace);
    }
}
