import com.revolv3r.generics.domain.Model;
import com.revolv3r.generics.domain.PlaneModel;
import com.revolv3r.generics.domain.TrainModel;
import com.revolv3r.generics.service.Shop;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        Shop<PlaneModel> planeShop = makePlaneshop();
        Shop<TrainModel> trainShop = makeTrainshop();
        Shop<Model> modelShop = makeModelshop();

        //planes
        PlaneModel pm = planeShop.buy();
        planeShop.sell(pm);

        Collection<PlaneModel> planes = new ArrayList<>();
        planes.add(new PlaneModel("Fokker"));
        planes.add(new PlaneModel("USS Salvation"));
        planeShop.buyLot(2, planes);

        planeShop.sellLot(planes);

        //trains
        TrainModel tm = trainShop.buy();
        trainShop.sell(tm);

        Collection<TrainModel> trains = new ArrayList<>();
        trains.add(new TrainModel("1215 London"));
        trains.add(new TrainModel("1860 Glasgow"));
        trainShop.buyLot(2, trains);

        trainShop.sellLot(trains);

        //models
        modelShop.sell(tm);
        modelShop.sellLot(trains);


    }

    public static Shop<PlaneModel> makePlaneshop() {
        return new Shop<PlaneModel>() {
            @Override
            public PlaneModel buy() {
                PlaneModel pm = new PlaneModel("Messchermitt");
                System.out.println(pm.getName());
                return pm;
            }

            @Override
            public void sell(PlaneModel aItem) {
                System.out.println(aItem.getName());
            }

            @Override
            public void buyLot(int aCount, Collection<? super PlaneModel> aCollection) {
                for (Object item : aCollection)
                    System.out.println("bought " + ((PlaneModel)item).getName());
            }

            @Override
            public void sellLot(Collection<? extends PlaneModel> aLot) {
                for (PlaneModel item : aLot)
                    System.out.println(item.getName());
            }
        };
    }

    public static Shop<TrainModel> makeTrainshop(){
        return new Shop<TrainModel>() {
            @Override
            public TrainModel buy() {
                TrainModel pm = new TrainModel("Swazie-Express");
                System.out.println(pm.getName());
                return pm;
            }

            @Override
            public void sell(TrainModel aItem) {
                System.out.println(aItem.getName());
            }

            @Override
            public void buyLot(int aCount, Collection<? super TrainModel> aCollection) {
                for (Object item : aCollection)
                    System.out.println("bought " + ((TrainModel)item).getName());
            }

            @Override
            public void sellLot(Collection<? extends TrainModel> aLot) {
                for (TrainModel item : aLot)
                    System.out.println(item.getName());
            }
        };
    }

    public static Shop<Model> makeModelshop() {
        return new Shop<Model>() {
            @Override
            public Model buy() {
                Model pm = new Model("Unknown model in box");
                System.out.println(pm.getName());
                return pm;
            }

            @Override
            public void sell(Model aItem) {
                System.out.println(aItem.getName());
            }

            @Override
            public void buyLot(int aCount, Collection<? super Model> aCollection) {
                for (Object item : aCollection)
                    System.out.println("bought " + ((PlaneModel)item).getName());
            }

            @Override
            public void sellLot(Collection<? extends Model> aLot) {
                for (Model item : aLot)
                    System.out.println(item.getName());
            }
        };
    }
}
