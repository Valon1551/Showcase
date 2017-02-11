package org.educama.acceptancetests.steps;

import net.thucydides.core.annotations.Step;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.task.Task;
import org.educama.acceptancetests.pages.ShipmentCapturePage;
import org.educama.acceptancetests.pages.ShipmentListPage;
import org.educama.acceptancetests.pages.TaskListPage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaskListSteps {

	ShipmentListPage shipmentsListPage;
    TaskListPage taskListPage;
	ShipmentCapturePage shipmentCapturePage;


	@Autowired
	TaskService taskService;




	@Step
	public void addTaskForAssignee(User assignee){
        Task task = taskService.newTask();
        task.setAssignee(assignee.getId());
        task.setName("Check shipment");
	}

	@Step
	public void openTaskListPage() {
		taskListPage.open();
	}

//	@Step
//	public void checksTheShipmentsList() {
//		assertThat("There are shipments in the shipment list.", shipmentsListPage.getShipmentsList().size() == 0, is(true));
//	}



    @Step
    public void checksTaskListForThreeTask() {
        List<String> taskList = taskListPage.getTaskList();
        int size = taskList.size();
        assertThat("There are " + size + " tasks in the shipment list. Three tasks are expected.", size == 3, is(true));
    }



//	@Step
//	public void checksTheShipmentListForOneShipment() {
//        List<String> shipmentsList = shipmentsListPage.getShipmentsList();
//        int size = shipmentsList.size();
//        assertThat("There are " + size + " shipment/s in the shipment list", size == 1, is(true));
//    }

//	@Step
//	public void addOneShipment() {
//		shipmentsListPage.openShipmentCapturePage();
//		shipmentCapturePage.createShipment();
//	}
}
