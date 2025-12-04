package com.javatechie.workflow;

import com.javatechie.dto.TravelRequest;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TravelWorkflow {

    @WorkflowMethod
    void bookTrip(TravelRequest travelRequest);


    /*
     * A Signal is an asynchronous message sent to a running 
     * Workflow Execution to change its state and control its flow:
     */
    @SignalMethod
    public void sendConfirmationSignal();

}
