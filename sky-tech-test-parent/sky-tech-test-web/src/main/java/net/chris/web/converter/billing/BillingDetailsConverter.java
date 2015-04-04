/**
 * 
 */
package net.chris.web.converter.billing;

import java.util.ArrayList;
import java.util.List;

import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.billing.dto.BuyAndKeep;
import net.chris.integration.billing.dto.Call;
import net.chris.integration.billing.dto.CallCharges;
import net.chris.integration.billing.dto.ChosenPackage;
import net.chris.integration.billing.dto.Rental;
import net.chris.integration.billing.dto.SkyStore;
import net.chris.integration.billing.dto.Statement;
import net.chris.integration.billing.dto.Subscription;
import net.chris.web.converter.IntegrationConverter;
import net.chris.web.converter.util.BeanUtils;
import net.chris.web.viewbean.billing.BillDetailsViewBean;
import net.chris.web.viewbean.billing.BuyAndKeepViewBean;
import net.chris.web.viewbean.billing.CallChargesViewBean;
import net.chris.web.viewbean.billing.CallViewBean;
import net.chris.web.viewbean.billing.ChosenPackageViewBean;
import net.chris.web.viewbean.billing.PeriodViewBean;
import net.chris.web.viewbean.billing.RentalViewBean;
import net.chris.web.viewbean.billing.SkyStoreViewBean;
import net.chris.web.viewbean.billing.StatementViewBean;
import net.chris.web.viewbean.billing.SubscriptionViewBean;

import org.springframework.core.convert.converter.Converter;

/**
 * Convert from a {@link BillDetails} returned by the integration layer into a {@link BillDetailsViewBean}.
 * 
 * @author Chris Hern
 * 
 */
@IntegrationConverter
public class BillingDetailsConverter implements Converter<BillDetails, BillDetailsViewBean> {

    @Override
    public BillDetailsViewBean convert(final BillDetails billDetails) {

        final BillDetailsViewBean pageBean = new BillDetailsViewBean();

        BeanUtils.copyProperties(billDetails, pageBean);

        pageBean.setStatement(convertStatement(billDetails.getStatement()));
        pageBean.setChosenPackage(convertChosenPackage(billDetails.getPackage()));
        pageBean.setCallCharges(convertCallCharges(billDetails.getCallCharges()));
        pageBean.setSkyStore(convertSkyStore(billDetails.getSkyStore()));

        return pageBean;
    }

    private StatementViewBean convertStatement(final Statement statement) {

        final StatementViewBean statementPageBean = new StatementViewBean();
        final PeriodViewBean periodPageBean = new PeriodViewBean();

        BeanUtils.copyProperties(statement, statementPageBean);
        BeanUtils.copyProperties(statement.getPeriod(), periodPageBean);

        statementPageBean.setPeriod(periodPageBean);

        return statementPageBean;
    }

    private ChosenPackageViewBean convertChosenPackage(final ChosenPackage chosenPackage) {

        final ChosenPackageViewBean chosenPackagePageBean = new ChosenPackageViewBean();
        final List<SubscriptionViewBean> subscriptionPageBeans = new ArrayList<SubscriptionViewBean>();

        for (final Subscription subscription : chosenPackage.getSubscriptions()) {

            final SubscriptionViewBean subscriptionPageBean = new SubscriptionViewBean();
            BeanUtils.copyProperties(subscription, subscriptionPageBean);
            subscriptionPageBeans.add(subscriptionPageBean);
        }

        BeanUtils.copyProperties(chosenPackage, chosenPackagePageBean);
        chosenPackagePageBean.setSubscriptions(subscriptionPageBeans);

        return chosenPackagePageBean;
    }

    private CallChargesViewBean convertCallCharges(final CallCharges callCharges) {

        final CallChargesViewBean callChargesPageBean = new CallChargesViewBean();
        final List<CallViewBean> callPageBeans = new ArrayList<CallViewBean>();

        for (final Call call : callCharges.getCalls()) {

            final CallViewBean callPageBean = new CallViewBean();
            BeanUtils.copyProperties(call, callPageBean);
            callPageBeans.add(callPageBean);
        }

        BeanUtils.copyProperties(callCharges, callChargesPageBean);
        callChargesPageBean.setCalls(callPageBeans);

        return callChargesPageBean;
    }

    private SkyStoreViewBean convertSkyStore(final SkyStore skyStore) {

        final SkyStoreViewBean skyStorePageBean = new SkyStoreViewBean();

        final List<RentalViewBean> rentalPageBeans = convertRentals(skyStore.getRentals());
        final List<BuyAndKeepViewBean> buyAndKeepPageBeans = convertBuyAndKeeps(skyStore.getBuyAndKeep());

        BeanUtils.copyProperties(skyStore, skyStorePageBean);
        skyStorePageBean.setRentals(rentalPageBeans);
        skyStorePageBean.setBuyAndKeep(buyAndKeepPageBeans);

        return skyStorePageBean;
    }

    private List<RentalViewBean> convertRentals(final List<Rental> rentals) {

        final List<RentalViewBean> rentalPageBeans = new ArrayList<RentalViewBean>();

        for (final Rental rental : rentals) {

            final RentalViewBean rentalPageBean = new RentalViewBean();
            BeanUtils.copyProperties(rental, rentalPageBean);
            rentalPageBeans.add(rentalPageBean);
        }

        return rentalPageBeans;
    }

    private List<BuyAndKeepViewBean> convertBuyAndKeeps(final List<BuyAndKeep> buyAndKeeps) {

        final List<BuyAndKeepViewBean> buyAndKeepPageBeans = new ArrayList<BuyAndKeepViewBean>();

        for (final BuyAndKeep buyAndKeep : buyAndKeeps) {

            final BuyAndKeepViewBean buyAndKeepPageBean = new BuyAndKeepViewBean();
            BeanUtils.copyProperties(buyAndKeep, buyAndKeepPageBean);
            buyAndKeepPageBeans.add(buyAndKeepPageBean);
        }

        return buyAndKeepPageBeans;
    }
}
