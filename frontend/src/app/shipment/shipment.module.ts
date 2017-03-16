import {NgModule} from "@angular/core";
import {SharedModule} from "../common/shared.module";
import {SHIPMENT_ROUTING} from "./routes/shipment.routes";
import {ShipmentService} from "./api/shipment.service";
import {ShipmentListPageComponent} from "./container/shipment-list-page.component";
import {ShipmentListComponent} from "./components/shipment-list.component";
import {ShipmentCapturePageComponent} from "./container/shipment-capture-page.component";
import {ShipmentCaptureComponent} from "./components/shipment-capture.component";
import {TaskListPageComponent} from "./container/task-list-page.component";
import {TaskListComponent} from "./components/task-list.component";
import {TaskService} from "./api/task.service";
import {ShipmentCapturePageTabComponent} from "./container/shipment-capture-page-tab.component";
import {ShipmentCaptureTwoComponent} from "./components/shipment-capture-two.component";

@NgModule({
    imports: [SharedModule, SHIPMENT_ROUTING],
    declarations: [ShipmentCapturePageComponent, ShipmentCaptureComponent,
        ShipmentListPageComponent, ShipmentListComponent, TaskListPageComponent, TaskListComponent, ShipmentCapturePageTabComponent, ShipmentCaptureTwoComponent],
    exports: [ShipmentListPageComponent, ShipmentCapturePageComponent, ShipmentCapturePageTabComponent, ShipmentCaptureTwoComponent],
    providers: [ShipmentService, TaskService]
})
export class ShipmentModule {
}
