package core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by majid on 12/4/16.
 */
public interface ProcessInstance {
    ProcessInstance startProcess (String processId);

    ProcessInstance startProcess(String processId,
                                 Map<String, Object> parameters);
    void signalEvent(String type,
                     Object event,
                     long processInstanceId);
    Collection<ProcessInstance> getProcessInstances();

    ProcessInstance getProcessInstance(long processInstanceId);
    void abortProcessInstance(long processInstanceId);
}
