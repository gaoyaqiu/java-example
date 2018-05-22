package com.gyq.jpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author gaoyaqiu
 * @date 2018/5/21
 */
@Entity
@Table(name = "t_report", schema = "shell_report", catalog = "")
public class TReportEntity {
    private long id;
    private String accountOwnerId;
    private String accountName;
    private String serviceAdministratorId;
    private String subscriptionId;
    private String subscriptionGuid;
    private String subscriptionName;
    private String reportDate;
    private Integer reportMonth;
    private Integer reportDay;
    private Integer reportYear;
    private String product;
    private String meterId;
    private String meterCategory;
    private String meterSubCategory;
    private String meterRegion;
    private String meterName;
    private BigDecimal consumedQuantity;
    private BigDecimal resourceRate;
    private BigDecimal extendedCost;
    private String resourceLocation;
    private String consumedService;
    private String instanceId;
    private String serviceInfo1;
    private String serviceInfo2;
    private String additionalInfo;
    private String tags;
    private String storeServiceIdentifier;
    private String departmentName;
    private String costCenter;
    private String unitOfMeasure;
    private String resourceGroup;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_owner_id")
    public String getAccountOwnerId() {
        return accountOwnerId;
    }

    public void setAccountOwnerId(String accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "service_administrator_id")
    public String getServiceAdministratorId() {
        return serviceAdministratorId;
    }

    public void setServiceAdministratorId(String serviceAdministratorId) {
        this.serviceAdministratorId = serviceAdministratorId;
    }

    @Basic
    @Column(name = "subscription_id")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Basic
    @Column(name = "subscription_guid")
    public String getSubscriptionGuid() {
        return subscriptionGuid;
    }

    public void setSubscriptionGuid(String subscriptionGuid) {
        this.subscriptionGuid = subscriptionGuid;
    }

    @Basic
    @Column(name = "subscription_name")
    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    @Basic
    @Column(name = "report_date")
    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Basic
    @Column(name = "report_month")
    public Integer getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(Integer reportMonth) {
        this.reportMonth = reportMonth;
    }

    @Basic
    @Column(name = "report_day")
    public Integer getReportDay() {
        return reportDay;
    }

    public void setReportDay(Integer reportDay) {
        this.reportDay = reportDay;
    }

    @Basic
    @Column(name = "report_year")
    public Integer getReportYear() {
        return reportYear;
    }

    public void setReportYear(Integer reportYear) {
        this.reportYear = reportYear;
    }

    @Basic
    @Column(name = "product")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "meter_id")
    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    @Basic
    @Column(name = "meter_category")
    public String getMeterCategory() {
        return meterCategory;
    }

    public void setMeterCategory(String meterCategory) {
        this.meterCategory = meterCategory;
    }

    @Basic
    @Column(name = "meter_sub_category")
    public String getMeterSubCategory() {
        return meterSubCategory;
    }

    public void setMeterSubCategory(String meterSubCategory) {
        this.meterSubCategory = meterSubCategory;
    }

    @Basic
    @Column(name = "meter_region")
    public String getMeterRegion() {
        return meterRegion;
    }

    public void setMeterRegion(String meterRegion) {
        this.meterRegion = meterRegion;
    }

    @Basic
    @Column(name = "meter_name")
    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    @Basic
    @Column(name = "consumed_quantity")
    public BigDecimal getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(BigDecimal consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    @Basic
    @Column(name = "resource_rate")
    public BigDecimal getResourceRate() {
        return resourceRate;
    }

    public void setResourceRate(BigDecimal resourceRate) {
        this.resourceRate = resourceRate;
    }

    @Basic
    @Column(name = "extended_cost")
    public BigDecimal getExtendedCost() {
        return extendedCost;
    }

    public void setExtendedCost(BigDecimal extendedCost) {
        this.extendedCost = extendedCost;
    }

    @Basic
    @Column(name = "resource_location")
    public String getResourceLocation() {
        return resourceLocation;
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    @Basic
    @Column(name = "consumed_service")
    public String getConsumedService() {
        return consumedService;
    }

    public void setConsumedService(String consumedService) {
        this.consumedService = consumedService;
    }

    @Basic
    @Column(name = "instance_id")
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Basic
    @Column(name = "service_info1")
    public String getServiceInfo1() {
        return serviceInfo1;
    }

    public void setServiceInfo1(String serviceInfo1) {
        this.serviceInfo1 = serviceInfo1;
    }

    @Basic
    @Column(name = "service_info2")
    public String getServiceInfo2() {
        return serviceInfo2;
    }

    public void setServiceInfo2(String serviceInfo2) {
        this.serviceInfo2 = serviceInfo2;
    }

    @Basic
    @Column(name = "additional_info")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "storeService_identifier")
    public String getStoreServiceIdentifier() {
        return storeServiceIdentifier;
    }

    public void setStoreServiceIdentifier(String storeServiceIdentifier) {
        this.storeServiceIdentifier = storeServiceIdentifier;
    }

    @Basic
    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "cost_center")
    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    @Basic
    @Column(name = "unit_of_measure")
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Basic
    @Column(name = "resource_group")
    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TReportEntity that = (TReportEntity) o;

        if (id != that.id) return false;
        if (accountOwnerId != null ? !accountOwnerId.equals(that.accountOwnerId) : that.accountOwnerId != null)
            return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (serviceAdministratorId != null ? !serviceAdministratorId.equals(that.serviceAdministratorId) : that.serviceAdministratorId != null)
            return false;
        if (subscriptionId != null ? !subscriptionId.equals(that.subscriptionId) : that.subscriptionId != null)
            return false;
        if (subscriptionGuid != null ? !subscriptionGuid.equals(that.subscriptionGuid) : that.subscriptionGuid != null)
            return false;
        if (subscriptionName != null ? !subscriptionName.equals(that.subscriptionName) : that.subscriptionName != null)
            return false;
        if (reportDate != null ? !reportDate.equals(that.reportDate) : that.reportDate != null) return false;
        if (reportMonth != null ? !reportMonth.equals(that.reportMonth) : that.reportMonth != null) return false;
        if (reportDay != null ? !reportDay.equals(that.reportDay) : that.reportDay != null) return false;
        if (reportYear != null ? !reportYear.equals(that.reportYear) : that.reportYear != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (meterId != null ? !meterId.equals(that.meterId) : that.meterId != null) return false;
        if (meterCategory != null ? !meterCategory.equals(that.meterCategory) : that.meterCategory != null)
            return false;
        if (meterSubCategory != null ? !meterSubCategory.equals(that.meterSubCategory) : that.meterSubCategory != null)
            return false;
        if (meterRegion != null ? !meterRegion.equals(that.meterRegion) : that.meterRegion != null) return false;
        if (meterName != null ? !meterName.equals(that.meterName) : that.meterName != null) return false;
        if (consumedQuantity != null ? !consumedQuantity.equals(that.consumedQuantity) : that.consumedQuantity != null)
            return false;
        if (resourceRate != null ? !resourceRate.equals(that.resourceRate) : that.resourceRate != null) return false;
        if (extendedCost != null ? !extendedCost.equals(that.extendedCost) : that.extendedCost != null) return false;
        if (resourceLocation != null ? !resourceLocation.equals(that.resourceLocation) : that.resourceLocation != null)
            return false;
        if (consumedService != null ? !consumedService.equals(that.consumedService) : that.consumedService != null)
            return false;
        if (instanceId != null ? !instanceId.equals(that.instanceId) : that.instanceId != null) return false;
        if (serviceInfo1 != null ? !serviceInfo1.equals(that.serviceInfo1) : that.serviceInfo1 != null) return false;
        if (serviceInfo2 != null ? !serviceInfo2.equals(that.serviceInfo2) : that.serviceInfo2 != null) return false;
        if (additionalInfo != null ? !additionalInfo.equals(that.additionalInfo) : that.additionalInfo != null)
            return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (storeServiceIdentifier != null ? !storeServiceIdentifier.equals(that.storeServiceIdentifier) : that.storeServiceIdentifier != null)
            return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (costCenter != null ? !costCenter.equals(that.costCenter) : that.costCenter != null) return false;
        if (unitOfMeasure != null ? !unitOfMeasure.equals(that.unitOfMeasure) : that.unitOfMeasure != null)
            return false;
        if (resourceGroup != null ? !resourceGroup.equals(that.resourceGroup) : that.resourceGroup != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accountOwnerId != null ? accountOwnerId.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (serviceAdministratorId != null ? serviceAdministratorId.hashCode() : 0);
        result = 31 * result + (subscriptionId != null ? subscriptionId.hashCode() : 0);
        result = 31 * result + (subscriptionGuid != null ? subscriptionGuid.hashCode() : 0);
        result = 31 * result + (subscriptionName != null ? subscriptionName.hashCode() : 0);
        result = 31 * result + (reportDate != null ? reportDate.hashCode() : 0);
        result = 31 * result + (reportMonth != null ? reportMonth.hashCode() : 0);
        result = 31 * result + (reportDay != null ? reportDay.hashCode() : 0);
        result = 31 * result + (reportYear != null ? reportYear.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (meterId != null ? meterId.hashCode() : 0);
        result = 31 * result + (meterCategory != null ? meterCategory.hashCode() : 0);
        result = 31 * result + (meterSubCategory != null ? meterSubCategory.hashCode() : 0);
        result = 31 * result + (meterRegion != null ? meterRegion.hashCode() : 0);
        result = 31 * result + (meterName != null ? meterName.hashCode() : 0);
        result = 31 * result + (consumedQuantity != null ? consumedQuantity.hashCode() : 0);
        result = 31 * result + (resourceRate != null ? resourceRate.hashCode() : 0);
        result = 31 * result + (extendedCost != null ? extendedCost.hashCode() : 0);
        result = 31 * result + (resourceLocation != null ? resourceLocation.hashCode() : 0);
        result = 31 * result + (consumedService != null ? consumedService.hashCode() : 0);
        result = 31 * result + (instanceId != null ? instanceId.hashCode() : 0);
        result = 31 * result + (serviceInfo1 != null ? serviceInfo1.hashCode() : 0);
        result = 31 * result + (serviceInfo2 != null ? serviceInfo2.hashCode() : 0);
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (storeServiceIdentifier != null ? storeServiceIdentifier.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (costCenter != null ? costCenter.hashCode() : 0);
        result = 31 * result + (unitOfMeasure != null ? unitOfMeasure.hashCode() : 0);
        result = 31 * result + (resourceGroup != null ? resourceGroup.hashCode() : 0);
        return result;
    }
}
