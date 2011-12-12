package com.clouway.networkingandgui.calculator;

import java.util.Hashtable;

/**
 * Used for containing Objects from the operation classes  and using their operations
 * Created by Krasimir Dimitrov
 * Date: 11/30/11
 * Time: 9:09 AM
 */
public class OperationHolder {
    private Hashtable<String, Operation> operationTable;

    /**
     * Constructor without parameters
     */
    public OperationHolder() {
        this.operationTable = new Hashtable<String, Operation>();
    }

    /**
     * Put an operation with her symbol as a key in a HashTable
     * @param textOfOperation the symbol of the operation used as key
     * @param operation  the operation object that we want to store
     */
    public void includeOperation(String textOfOperation, Operation operation) {
        operationTable.put(textOfOperation, operation);
    }

    /**
     *  Extract an operation from the HashTable using her symbol so we can use it
     * @param textOfOperation the symbol of the operation that we want to use
     * @return  the object that handle the current operation
     */
    public Operation useOperation(String textOfOperation) {
        return operationTable.get(textOfOperation);
    }
}
