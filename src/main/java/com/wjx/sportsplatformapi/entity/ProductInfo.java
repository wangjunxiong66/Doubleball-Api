package com.wjx.sportsplatformapi.entity;

import java.io.Serializable;

public class ProductInfo implements Serializable {

    public int id;
    public String supplier_sn;
    public String product_name;
    public String brand_name;
    public String product_code;
    public String first_category_name;
    public String secondary_category_name;
    public String third_category_name;
    public String supplier_spu_code;
    public String supplier_sku_code;
    public String spu_code;
    public String sku_code;
    public String product_spec;
    public String expiry_time;
    public String pack_unit;
    public String box_quantity;
    public String jd_price;
    public String jd_page_url;
    public String tmall_price;
    public String tmall_page_url;
    public String other_refer_price;
    public String selling_price;
    public String tax_cost_price;
    public String cost_price;
    public String tax_rate;
    public int  stock;
    public String  sales_desc;
    public String  submit_time;
    public String  supplier_invoice_type;
    public String  not_delivery_range;
    public String  supplier_settlement_price;
    public String  shop_cost_price_base;
    public String  memo1;
    public String  memo2;
    public String  memo3;
    public String  memo4;
    public String  memo5;
    public String create_time;
    public String  update_time;
    public int first_category_id;
    public int secondary_category_id;
    public int third_category_id;
    public String refer_cost_price_base;
    public int is_uniform_price;
    public String refund_address;
    public int is_putaway_info_complete;
    public int putaway_enable;
    public String delivery_cycle;
    public int version;
    public int core_shop_putaway_status;
    public String remark;
    public String start_time;
    public String end_time;
    public int auth_state;

    public ProductInfo() {
    }

    public ProductInfo(String supplier_sn, String product_name, String brand_name, String product_code, String first_category_name, String secondary_category_name, String third_category_name, String supplier_spu_code, String supplier_sku_code, String spu_code, String sku_code, String product_spec, String expiry_time, String pack_unit, String box_quantity, String jd_price, String jd_page_url, String tmall_price, String tmall_page_url, String other_refer_price, String selling_price, String tax_cost_price, String cost_price, String tax_rate, int stock, String sales_desc, String submit_time, String supplier_invoice_type, String not_delivery_range, String supplier_settlement_price, String shop_cost_price_base, String memo1, String memo2, String memo3, String memo4, String memo5, String create_time, String update_time, int first_category_id, int secondary_category_id, int third_category_id, String refer_cost_price_base, int is_uniform_price, String refund_address, int is_putaway_info_complete, int putaway_enable, String delivery_cycle, int version, int core_shop_putaway_status, String remark, String start_time, String end_time, int auth_state) {
        this.supplier_sn = supplier_sn;
        this.product_name = product_name;
        this.brand_name = brand_name;
        this.product_code = product_code;
        this.first_category_name = first_category_name;
        this.secondary_category_name = secondary_category_name;
        this.third_category_name = third_category_name;
        this.supplier_spu_code = supplier_spu_code;
        this.supplier_sku_code = supplier_sku_code;
        this.spu_code = spu_code;
        this.sku_code = sku_code;
        this.product_spec = product_spec;
        this.expiry_time = expiry_time;
        this.pack_unit = pack_unit;
        this.box_quantity = box_quantity;
        this.jd_price = jd_price;
        this.jd_page_url = jd_page_url;
        this.tmall_price = tmall_price;
        this.tmall_page_url = tmall_page_url;
        this.other_refer_price = other_refer_price;
        this.selling_price = selling_price;
        this.tax_cost_price = tax_cost_price;
        this.cost_price = cost_price;
        this.tax_rate = tax_rate;
        this.stock = stock;
        this.sales_desc = sales_desc;
        this.submit_time = submit_time;
        this.supplier_invoice_type = supplier_invoice_type;
        this.not_delivery_range = not_delivery_range;
        this.supplier_settlement_price = supplier_settlement_price;
        this.shop_cost_price_base = shop_cost_price_base;
        this.memo1 = memo1;
        this.memo2 = memo2;
        this.memo3 = memo3;
        this.memo4 = memo4;
        this.memo5 = memo5;
        this.create_time = create_time;
        this.update_time = update_time;
        this.first_category_id = first_category_id;
        this.secondary_category_id = secondary_category_id;
        this.third_category_id = third_category_id;
        this.refer_cost_price_base = refer_cost_price_base;
        this.is_uniform_price = is_uniform_price;
        this.refund_address = refund_address;
        this.is_putaway_info_complete = is_putaway_info_complete;
        this.putaway_enable = putaway_enable;
        this.delivery_cycle = delivery_cycle;
        this.version = version;
        this.core_shop_putaway_status = core_shop_putaway_status;
        this.remark = remark;
        this.start_time = start_time;
        this.end_time = end_time;
        this.auth_state = auth_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplier_sn() {
        return supplier_sn;
    }

    public void setSupplier_sn(String supplier_sn) {
        this.supplier_sn = supplier_sn;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getFirst_category_name() {
        return first_category_name;
    }

    public void setFirst_category_name(String first_category_name) {
        this.first_category_name = first_category_name;
    }

    public String getSecondary_category_name() {
        return secondary_category_name;
    }

    public void setSecondary_category_name(String secondary_category_name) {
        this.secondary_category_name = secondary_category_name;
    }

    public String getThird_category_name() {
        return third_category_name;
    }

    public void setThird_category_name(String third_category_name) {
        this.third_category_name = third_category_name;
    }

    public String getSupplier_spu_code() {
        return supplier_spu_code;
    }

    public void setSupplier_spu_code(String supplier_spu_code) {
        this.supplier_spu_code = supplier_spu_code;
    }

    public String getSupplier_sku_code() {
        return supplier_sku_code;
    }

    public void setSupplier_sku_code(String supplier_sku_code) {
        this.supplier_sku_code = supplier_sku_code;
    }

    public String getSpu_code() {
        return spu_code;
    }

    public void setSpu_code(String spu_code) {
        this.spu_code = spu_code;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public String getProduct_spec() {
        return product_spec;
    }

    public void setProduct_spec(String product_spec) {
        this.product_spec = product_spec;
    }

    public String getExpiry_time() {
        return expiry_time;
    }

    public void setExpiry_time(String expiry_time) {
        this.expiry_time = expiry_time;
    }

    public String getPack_unit() {
        return pack_unit;
    }

    public void setPack_unit(String pack_unit) {
        this.pack_unit = pack_unit;
    }

    public String getBox_quantity() {
        return box_quantity;
    }

    public void setBox_quantity(String box_quantity) {
        this.box_quantity = box_quantity;
    }

    public String getJd_price() {
        return jd_price;
    }

    public void setJd_price(String jd_price) {
        this.jd_price = jd_price;
    }

    public String getJd_page_url() {
        return jd_page_url;
    }

    public void setJd_page_url(String jd_page_url) {
        this.jd_page_url = jd_page_url;
    }

    public String getTmall_price() {
        return tmall_price;
    }

    public void setTmall_price(String tmall_price) {
        this.tmall_price = tmall_price;
    }

    public String getTmall_page_url() {
        return tmall_page_url;
    }

    public void setTmall_page_url(String tmall_page_url) {
        this.tmall_page_url = tmall_page_url;
    }

    public String getOther_refer_price() {
        return other_refer_price;
    }

    public void setOther_refer_price(String other_refer_price) {
        this.other_refer_price = other_refer_price;
    }

    public String getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(String selling_price) {
        this.selling_price = selling_price;
    }

    public String getTax_cost_price() {
        return tax_cost_price;
    }

    public void setTax_cost_price(String tax_cost_price) {
        this.tax_cost_price = tax_cost_price;
    }

    public String getCost_price() {
        return cost_price;
    }

    public void setCost_price(String cost_price) {
        this.cost_price = cost_price;
    }

    public String getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSales_desc() {
        return sales_desc;
    }

    public void setSales_desc(String sales_desc) {
        this.sales_desc = sales_desc;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public String getSupplier_invoice_type() {
        return supplier_invoice_type;
    }

    public void setSupplier_invoice_type(String supplier_invoice_type) {
        this.supplier_invoice_type = supplier_invoice_type;
    }

    public String getNot_delivery_range() {
        return not_delivery_range;
    }

    public void setNot_delivery_range(String not_delivery_range) {
        this.not_delivery_range = not_delivery_range;
    }

    public String getSupplier_settlement_price() {
        return supplier_settlement_price;
    }

    public void setSupplier_settlement_price(String supplier_settlement_price) {
        this.supplier_settlement_price = supplier_settlement_price;
    }

    public String getShop_cost_price_base() {
        return shop_cost_price_base;
    }

    public void setShop_cost_price_base(String shop_cost_price_base) {
        this.shop_cost_price_base = shop_cost_price_base;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    public String getMemo4() {
        return memo4;
    }

    public void setMemo4(String memo4) {
        this.memo4 = memo4;
    }

    public String getMemo5() {
        return memo5;
    }

    public void setMemo5(String memo5) {
        this.memo5 = memo5;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getFirst_category_id() {
        return first_category_id;
    }

    public void setFirst_category_id(int first_category_id) {
        this.first_category_id = first_category_id;
    }

    public int getSecondary_category_id() {
        return secondary_category_id;
    }

    public void setSecondary_category_id(int secondary_category_id) {
        this.secondary_category_id = secondary_category_id;
    }

    public int getThird_category_id() {
        return third_category_id;
    }

    public void setThird_category_id(int third_category_id) {
        this.third_category_id = third_category_id;
    }

    public String getRefer_cost_price_base() {
        return refer_cost_price_base;
    }

    public void setRefer_cost_price_base(String refer_cost_price_base) {
        this.refer_cost_price_base = refer_cost_price_base;
    }

    public int getIs_uniform_price() {
        return is_uniform_price;
    }

    public void setIs_uniform_price(int is_uniform_price) {
        this.is_uniform_price = is_uniform_price;
    }

    public String getRefund_address() {
        return refund_address;
    }

    public void setRefund_address(String refund_address) {
        this.refund_address = refund_address;
    }

    public int getIs_putaway_info_complete() {
        return is_putaway_info_complete;
    }

    public void setIs_putaway_info_complete(int is_putaway_info_complete) {
        this.is_putaway_info_complete = is_putaway_info_complete;
    }

    public int getPutaway_enable() {
        return putaway_enable;
    }

    public void setPutaway_enable(int putaway_enable) {
        this.putaway_enable = putaway_enable;
    }

    public String getDelivery_cycle() {
        return delivery_cycle;
    }

    public void setDelivery_cycle(String delivery_cycle) {
        this.delivery_cycle = delivery_cycle;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCore_shop_putaway_status() {
        return core_shop_putaway_status;
    }

    public void setCore_shop_putaway_status(int core_shop_putaway_status) {
        this.core_shop_putaway_status = core_shop_putaway_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getAuth_state() {
        return auth_state;
    }

    public void setAuth_state(int auth_state) {
        this.auth_state = auth_state;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", supplier_sn='" + supplier_sn + '\'' +
                ", product_name='" + product_name + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", product_code='" + product_code + '\'' +
                ", first_category_name='" + first_category_name + '\'' +
                ", secondary_category_name='" + secondary_category_name + '\'' +
                ", third_category_name='" + third_category_name + '\'' +
                ", supplier_spu_code='" + supplier_spu_code + '\'' +
                ", supplier_sku_code='" + supplier_sku_code + '\'' +
                ", spu_code='" + spu_code + '\'' +
                ", sku_code='" + sku_code + '\'' +
                ", product_spec='" + product_spec + '\'' +
                ", expiry_time='" + expiry_time + '\'' +
                ", pack_unit='" + pack_unit + '\'' +
                ", box_quantity='" + box_quantity + '\'' +
                ", jd_price='" + jd_price + '\'' +
                ", jd_page_url='" + jd_page_url + '\'' +
                ", tmall_price='" + tmall_price + '\'' +
                ", tmall_page_url='" + tmall_page_url + '\'' +
                ", other_refer_price='" + other_refer_price + '\'' +
                ", selling_price='" + selling_price + '\'' +
                ", tax_cost_price='" + tax_cost_price + '\'' +
                ", cost_price='" + cost_price + '\'' +
                ", tax_rate='" + tax_rate + '\'' +
                ", stock=" + stock +
                ", sales_desc='" + sales_desc + '\'' +
                ", submit_time='" + submit_time + '\'' +
                ", supplier_invoice_type='" + supplier_invoice_type + '\'' +
                ", not_delivery_range='" + not_delivery_range + '\'' +
                ", supplier_settlement_price='" + supplier_settlement_price + '\'' +
                ", shop_cost_price_base='" + shop_cost_price_base + '\'' +
                ", memo1='" + memo1 + '\'' +
                ", memo2='" + memo2 + '\'' +
                ", memo3='" + memo3 + '\'' +
                ", memo4='" + memo4 + '\'' +
                ", memo5='" + memo5 + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", first_category_id=" + first_category_id +
                ", secondary_category_id=" + secondary_category_id +
                ", third_category_id=" + third_category_id +
                ", refer_cost_price_base='" + refer_cost_price_base + '\'' +
                ", is_uniform_price=" + is_uniform_price +
                ", refund_address='" + refund_address + '\'' +
                ", is_putaway_info_complete=" + is_putaway_info_complete +
                ", putaway_enable=" + putaway_enable +
                ", delivery_cycle='" + delivery_cycle + '\'' +
                ", version=" + version +
                ", core_shop_putaway_status=" + core_shop_putaway_status +
                ", remark='" + remark + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", auth_state=" + auth_state +
                '}';
    }
}

