package com.challenge.conductor.conductchallenge.vo;

import java.util.List;

public class ExtratoVO {

    private List<PurchaseVO> purchases;
    private String lastPage;

    public List<PurchaseVO> getPurchaseVOS() {
        return purchases;
    }

    public void setPurchaseVOS(List<PurchaseVO> purchaseVOS) {
        this.purchases = purchaseVOS;
    }

    public String getLastPage() {
        return lastPage;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }
}
