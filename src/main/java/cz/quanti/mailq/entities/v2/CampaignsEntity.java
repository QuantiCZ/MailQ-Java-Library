package cz.quanti.mailq.entities.v2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CampaignsEntity extends BaseEntity implements Iterable<CampaignEntity> {

    private List<CampaignEntity> campaigns = new ArrayList<>();

    public CampaignsEntity(List<CampaignEntity> campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public Iterator<CampaignEntity> iterator() {
        return campaigns.iterator();
    }

    @Override
    public void forEach(Consumer<? super CampaignEntity> action) {
        campaigns.forEach(action);
    }

    @Override
    public Spliterator<CampaignEntity> spliterator() {
        return campaigns.spliterator();
    }


}
