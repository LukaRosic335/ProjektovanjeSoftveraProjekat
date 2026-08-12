/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import transfer.util.Operation;

/**
 *
 * @author jevrozim
 */
public class Request {
    private Object data;
    private Operation operation;

    public Request() {
    }

    public Request(Object data, Operation operation) {
        this.data = data;
        this.operation = operation;
    }

    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
}
