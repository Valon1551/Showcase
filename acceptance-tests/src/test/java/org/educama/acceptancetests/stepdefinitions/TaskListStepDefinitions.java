package org.educama.acceptancetests.stepdefinitions;

import net.thucydides.core.annotations.Steps;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.User;
import org.educama.acceptancetests.steps.TaskListSteps;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskListStepDefinitions extends GlobalStepDefinitions {

    // Needed for User Creation
    @Autowired
    IdentityService identityService;

    @Steps
    TaskListSteps user;

    User camundaUserTom;
    User camundaUserJerry;


    @BeforeStory
    public void createUserBeforeStory() {
        //create Tom
        User camundaUser = identityService.newUser("Tom");
        camundaUser.setPassword("tom");
        camundaUser.setFirstName("Tom");
        camundaUser.setLastName("Tomminger");
        identityService.saveUser(camundaUser);

        camundaUserTom = camundaUser;

        //create Jerry
        User camundaUser2 = identityService.newUser("Jerry");
        camundaUser2.setPassword("jerry");
        camundaUser2.setFirstName("Jerry");
        camundaUser2.setLastName("Jerringer");
        identityService.saveUser(camundaUser2);

        camundaUserJerry = camundaUser2;

    }

	/*
     * Empty Caselist
	 */
    @Given("there are $number tasks with name 'Check shipment' assigned to $assignee")
    public void givenThereAreNumberTasksWithNameCheckShipmentAssignedToName(int number, String assignee) {
        switch(assignee){
            case "Tom":
                for (int i = 0; i < number; i++)
                {
                    user.addTaskForAssignee(camundaUserTom);
                }
                break;
            case "Jerry":
                for (int i = 0; i < number; i++)
                {
                    user.addTaskForAssignee(camundaUserJerry);
                }
                break;
        }
    }

    @When("Tom requests the list of tasks")
    public void whenTomRequestsTheListOfTasks() {
        // nothing to do
    }

    @Then("Tom sees 3 tasks with name 'Check shipment'")
    public void thenISeeAnEmptyList() {
        user.checksTheShipmentsList();
    }

    /*
     * Caselist with one case
     */
    @Given("there are 2 tasks with name 'Check shipment' assigned to Jerry")
    public void givenThereIsOneShipment() {
        user.openShipmentsListPage();
        user.addOneShipment();
    }

    @Then("Tom sees an empty list")
    public void thenISeeOneShipment() {
        user.checksTheShipmentListForOneShipment();
    }
}
