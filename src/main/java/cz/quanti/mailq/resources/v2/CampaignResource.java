package cz.quanti.mailq.resources.v2;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.quanti.mailq.Connector;
import cz.quanti.mailq.Pagination;
import cz.quanti.mailq.Request;
import cz.quanti.mailq.entities.v2.CampaignEntity;
import cz.quanti.mailq.entities.v2.CampaignsEntity;
import cz.quanti.mailq.exceptions.ApiException;
import cz.quanti.mailq.exceptions.InvalidRequestException;
import org.apache.http.client.methods.HttpGet;

@Singleton
public class CampaignResource extends BaseResource {

    @Inject
    private CampaignResource(Connector connector) {
        super(connector);
    }

    public CampaignsEntity getCampaigns(Pagination pagination) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/campaigns")
                .parameter("limit",pagination.getLimit().toString())
                .parameter("offset",pagination.getOffset().toString())
                .build();
        return this.getConnector().send(request, CampaignsEntity.class);
    }

    public CampaignEntity getCampaign(Long id) throws ApiException, InvalidRequestException {
        Request request = Request.builder(HttpGet.METHOD_NAME,"/campaigns/"+id).build();
        return this.getConnector().send(request, CampaignEntity.class);
    }



}
