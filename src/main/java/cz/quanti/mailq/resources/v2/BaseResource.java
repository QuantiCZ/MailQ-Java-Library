package cz.quanti.mailq.resources.v2;


import cz.quanti.mailq.Connector;

public class BaseResource {

    private Connector connector;

    public BaseResource(Connector connector) {
        this.connector = connector;
    }

    protected Connector getConnector() {
        return connector;
    }
}
