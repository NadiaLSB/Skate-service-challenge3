package Reto3Ciclo3.Reto3Ciclo3.reports;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;

public class countClients {

    private Long total;
    private entityClient client;

    public countClients(Long total, entityClient client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public entityClient getClient() {
        return client;
    }

    public void setClient(entityClient client) {
        this.client = client;
    }

}
