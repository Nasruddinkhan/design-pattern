package com.mypractice.designpattern.adapterpattern.payd;

public interface PayD {

    public String getCustCardNo();

    public String getCardOwnerName();

    public String getCardExpMonthDate();

    public Integer getCVVNo();

    public Double getTotalAmmount();

    public void setCustCardNo(String custCardNo);

    public void setCardOwnerName(String cardOwnerName);

    public void setCardExpMonthDate(String cardExpMonthDate);

    public void setCVVNo(Integer cVVNo);

    public void setTotalAmmount(Double totalAmmount);
}
