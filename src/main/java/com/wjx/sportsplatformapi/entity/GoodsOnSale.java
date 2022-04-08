package com.wjx.sportsplatformapi.entity;

public class GoodsOnSale {

    //  设置上架商品公用信息-----设置上架商品公用信息-----设置上架商品公用信息
    //  店铺ID
    public int shop_id ;
    //  规格类型
    public String spec_type ;
    //  上架用序号
    public String issue ;
    //  基础信息-----基础信息-----基础信息-----基础信息-----基础信息-----基础信息-----基础信息
    //  商品类型
    public String product_type;
    //  商品名称
    public String product_name ;
    //  商品副标题
    public String sub_product_name;
    //  商品主图张数
    public int main_picture_num ;
    //  商品轮播图张数
    public int carousel_figure_num ;
    //  商品分类一级
    public String first_category_name ;
    //  商品分类二级
    public String secondary_category_name ;
    //  商品短标题
    public String short_name;
    //  商品分组
    public String group ;
    //  商品支持
    public String label ;
    //  价格库存-----价格库存-----价格库存-----价格库存-----价格库存-----价格库存-----价格库存
    //  商品规格
    public String good_specification ;
    //  礼包内商品编码
    public String peck_gift_good_code ;
    //  规格
    public String product_spec ;
    //  子规格
    public String product_spec_item ;
    //  规格图张数
    public int spec_picture__num ;
    //  售卖价格
    public float selling_price ;
    //  划线价
    public float original_price ;
    //  成本价
    public float cost_price ;
    //  库存量
    public int stock ;
    //  库存预警
    public int stock_warning ;
    //  商品编码
    public String product_code ;
    //  商品条形码
    public String product_sn ;
    //  商品详情显示库存，显示或隐藏
    public String stock_hide ;
    //  已出售数
    public int virtual_sales ;
    //  商品详情显示销量，显示或隐藏
    public String sales_hide ;
    //  物流设置-----物流设置-----物流设置-----物流设置-----物流设置-----物流设置-----物流设置
    //  物流支持，快递发货、同城配送、上门自提
    public String dispatch_mode ;
    //  快递运费，“统一运费”或者“运费模板”
    public String express_price ;
    //  运费模板，取自数据库
    public String express_template ;
    //  其他设置-----其他设置-----其他设置-----其他设置-----其他设置-----其他设置-----其他设置
    //  定时下架
    public String auto_warehouse_time ;
    //  状态，上架售卖、上架隐藏、定时上架、放置仓库
    public String status ;
    //  开启限购，是或否
    public String is_buy_num_limit ;
    //  起购数量
    public int min_buy ;
    //  每人限购数量
    public int max_buy_total ;
    //  浏览权限
    public String browse_authority ;
    //  购买权限
    public String buy_authority ;
    //  参与会员权益，会员卡、会员价、会员等级折扣
    public String join_member_discount ;
    //  商品详情-----商品详情-----商品详情-----商品详情-----商品详情-----商品详情-----商品详情-----商品详情
    //  推广图文件名
    public String promotion_diagram_name ;
    //  推广图链接
    public String promotion_diagram_link ;
    //  推广图会员等级是否展示
    public String promotion_diagram_degree ;
    //  商品详情图张数
    public int detailed_diagram_num ;
    //  授权图文件名
    public String authorize_diagram_name ;
    //  公用图文件名
    public String common_diagram_name ;
    //  积分抵扣活动设置-----积分抵扣活动设置-----积分抵扣活动设置-----积分抵扣活动设置-----积分抵扣活动设置-----积分抵扣活动设置
    //  活动名称
    public String activity_name ;
    //  活动开始时间
    public String activity_start_time ;
    //  活动结束时间
    public String activity_end_time ;
    //  活动渠道
    public String activity_channel ;
    //  规则设置-----规则设置-----规则设置-----规则设置-----规则设置-----规则设置-----规则设置-----规则设置-----规则设置
    //  规则1活动对象，全部会员、会员等级、会员标签
    public String activity_object ;
    //  规则1会员等级
    public String member_degree ;
    //  规则1最大积分抵扣
    public int credit ;
    //  规则1允许多件累计抵扣
    public String allow_accumulate ;

    public GoodsOnSale() {
    }

    public GoodsOnSale(int shop_id, String spec_type, String issue, String product_type, String product_name, String sub_product_name, int main_picture_num, int carousel_figure_num, String first_category_name, String secondary_category_name, String short_name, String group, String label, String good_specification, String peck_gift_good_code, String product_spec, String product_spec_item, int spec_picture__num, float selling_price, float original_price, float cost_price, int stock, int stock_warning, String product_code, String product_sn, String stock_hide, int virtual_sales, String sales_hide, String dispatch_mode, String express_price, String express_template, String auto_warehouse_time, String status, String is_buy_num_limit, int min_buy, int max_buy_total, String browse_authority, String buy_authority, String join_member_discount, String promotion_diagram_name, String promotion_diagram_link, String promotion_diagram_degree, int detailed_diagram_num, String authorize_diagram_name, String common_diagram_name, String activity_name, String activity_start_time, String activity_end_time, String activity_channel, String activity_object, String member_degree, int credit, String allow_accumulate) {
        this.shop_id = shop_id;
        this.spec_type = spec_type;
        this.issue = issue;
        this.product_type = product_type;
        this.product_name = product_name;
        this.sub_product_name = sub_product_name;
        this.main_picture_num = main_picture_num;
        this.carousel_figure_num = carousel_figure_num;
        this.first_category_name = first_category_name;
        this.secondary_category_name = secondary_category_name;
        this.short_name = short_name;
        this.group = group;
        this.label = label;
        this.good_specification = good_specification;
        this.peck_gift_good_code = peck_gift_good_code;
        this.product_spec = product_spec;
        this.product_spec_item = product_spec_item;
        this.spec_picture__num = spec_picture__num;
        this.selling_price = selling_price;
        this.original_price = original_price;
        this.cost_price = cost_price;
        this.stock = stock;
        this.stock_warning = stock_warning;
        this.product_code = product_code;
        this.product_sn = product_sn;
        this.stock_hide = stock_hide;
        this.virtual_sales = virtual_sales;
        this.sales_hide = sales_hide;
        this.dispatch_mode = dispatch_mode;
        this.express_price = express_price;
        this.express_template = express_template;
        this.auto_warehouse_time = auto_warehouse_time;
        this.status = status;
        this.is_buy_num_limit = is_buy_num_limit;
        this.min_buy = min_buy;
        this.max_buy_total = max_buy_total;
        this.browse_authority = browse_authority;
        this.buy_authority = buy_authority;
        this.join_member_discount = join_member_discount;
        this.promotion_diagram_name = promotion_diagram_name;
        this.promotion_diagram_link = promotion_diagram_link;
        this.promotion_diagram_degree = promotion_diagram_degree;
        this.detailed_diagram_num = detailed_diagram_num;
        this.authorize_diagram_name = authorize_diagram_name;
        this.common_diagram_name = common_diagram_name;
        this.activity_name = activity_name;
        this.activity_start_time = activity_start_time;
        this.activity_end_time = activity_end_time;
        this.activity_channel = activity_channel;
        this.activity_object = activity_object;
        this.member_degree = member_degree;
        this.credit = credit;
        this.allow_accumulate = allow_accumulate;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getSpec_type() {
        return spec_type;
    }

    public void setSpec_type(String spec_type) {
        this.spec_type = spec_type;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSub_product_name() {
        return sub_product_name;
    }

    public void setSub_product_name(String sub_product_name) {
        this.sub_product_name = sub_product_name;
    }

    public int getMain_picture_num() {
        return main_picture_num;
    }

    public void setMain_picture_num(int main_picture_num) {
        this.main_picture_num = main_picture_num;
    }

    public int getCarousel_figure_num() {
        return carousel_figure_num;
    }

    public void setCarousel_figure_num(int carousel_figure_num) {
        this.carousel_figure_num = carousel_figure_num;
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

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGood_specification() {
        return good_specification;
    }

    public void setGood_specification(String good_specification) {
        this.good_specification = good_specification;
    }

    public String getPeck_gift_good_code() {
        return peck_gift_good_code;
    }

    public void setPeck_gift_good_code(String peck_gift_good_code) {
        this.peck_gift_good_code = peck_gift_good_code;
    }

    public String getProduct_spec() {
        return product_spec;
    }

    public void setProduct_spec(String product_spec) {
        this.product_spec = product_spec;
    }

    public String getProduct_spec_item() {
        return product_spec_item;
    }

    public void setProduct_spec_item(String product_spec_item) {
        this.product_spec_item = product_spec_item;
    }

    public int getSpec_picture__num() {
        return spec_picture__num;
    }

    public void setSpec_picture__num(int spec_picture__num) {
        this.spec_picture__num = spec_picture__num;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(float original_price) {
        this.original_price = original_price;
    }

    public float getCost_price() {
        return cost_price;
    }

    public void setCost_price(float cost_price) {
        this.cost_price = cost_price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_warning() {
        return stock_warning;
    }

    public void setStock_warning(int stock_warning) {
        this.stock_warning = stock_warning;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_sn() {
        return product_sn;
    }

    public void setProduct_sn(String product_sn) {
        this.product_sn = product_sn;
    }

    public String getStock_hide() {
        return stock_hide;
    }

    public void setStock_hide(String stock_hide) {
        this.stock_hide = stock_hide;
    }

    public int getVirtual_sales() {
        return virtual_sales;
    }

    public void setVirtual_sales(int virtual_sales) {
        this.virtual_sales = virtual_sales;
    }

    public String getSales_hide() {
        return sales_hide;
    }

    public void setSales_hide(String sales_hide) {
        this.sales_hide = sales_hide;
    }

    public String getDispatch_mode() {
        return dispatch_mode;
    }

    public void setDispatch_mode(String dispatch_mode) {
        this.dispatch_mode = dispatch_mode;
    }

    public String getExpress_price() {
        return express_price;
    }

    public void setExpress_price(String express_price) {
        this.express_price = express_price;
    }

    public String getExpress_template() {
        return express_template;
    }

    public void setExpress_template(String express_template) {
        this.express_template = express_template;
    }

    public String getAuto_warehouse_time() {
        return auto_warehouse_time;
    }

    public void setAuto_warehouse_time(String auto_warehouse_time) {
        this.auto_warehouse_time = auto_warehouse_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_buy_num_limit() {
        return is_buy_num_limit;
    }

    public void setIs_buy_num_limit(String is_buy_num_limit) {
        this.is_buy_num_limit = is_buy_num_limit;
    }

    public int getMin_buy() {
        return min_buy;
    }

    public void setMin_buy(int min_buy) {
        this.min_buy = min_buy;
    }

    public int getMax_buy_total() {
        return max_buy_total;
    }

    public void setMax_buy_total(int max_buy_total) {
        this.max_buy_total = max_buy_total;
    }

    public String getBrowse_authority() {
        return browse_authority;
    }

    public void setBrowse_authority(String browse_authority) {
        this.browse_authority = browse_authority;
    }

    public String getBuy_authority() {
        return buy_authority;
    }

    public void setBuy_authority(String buy_authority) {
        this.buy_authority = buy_authority;
    }

    public String getJoin_member_discount() {
        return join_member_discount;
    }

    public void setJoin_member_discount(String join_member_discount) {
        this.join_member_discount = join_member_discount;
    }

    public String getPromotion_diagram_name() {
        return promotion_diagram_name;
    }

    public void setPromotion_diagram_name(String promotion_diagram_name) {
        this.promotion_diagram_name = promotion_diagram_name;
    }

    public String getPromotion_diagram_link() {
        return promotion_diagram_link;
    }

    public void setPromotion_diagram_link(String promotion_diagram_link) {
        this.promotion_diagram_link = promotion_diagram_link;
    }

    public String getPromotion_diagram_degree() {
        return promotion_diagram_degree;
    }

    public void setPromotion_diagram_degree(String promotion_diagram_degree) {
        this.promotion_diagram_degree = promotion_diagram_degree;
    }

    public int getDetailed_diagram_num() {
        return detailed_diagram_num;
    }

    public void setDetailed_diagram_num(int detailed_diagram_num) {
        this.detailed_diagram_num = detailed_diagram_num;
    }

    public String getAuthorize_diagram_name() {
        return authorize_diagram_name;
    }

    public void setAuthorize_diagram_name(String authorize_diagram_name) {
        this.authorize_diagram_name = authorize_diagram_name;
    }

    public String getCommon_diagram_name() {
        return common_diagram_name;
    }

    public void setCommon_diagram_name(String common_diagram_name) {
        this.common_diagram_name = common_diagram_name;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_start_time() {
        return activity_start_time;
    }

    public void setActivity_start_time(String activity_start_time) {
        this.activity_start_time = activity_start_time;
    }

    public String getActivity_end_time() {
        return activity_end_time;
    }

    public void setActivity_end_time(String activity_end_time) {
        this.activity_end_time = activity_end_time;
    }

    public String getActivity_channel() {
        return activity_channel;
    }

    public void setActivity_channel(String activity_channel) {
        this.activity_channel = activity_channel;
    }

    public String getActivity_object() {
        return activity_object;
    }

    public void setActivity_object(String activity_object) {
        this.activity_object = activity_object;
    }

    public String getMember_degree() {
        return member_degree;
    }

    public void setMember_degree(String member_degree) {
        this.member_degree = member_degree;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getAllow_accumulate() {
        return allow_accumulate;
    }

    public void setAllow_accumulate(String allow_accumulate) {
        this.allow_accumulate = allow_accumulate;
    }

    @Override
    public String toString() {
        return "GoodsOnSale{" +
                "shop_id=" + shop_id +
                ", spec_type='" + spec_type + '\'' +
                ", issue='" + issue + '\'' +
                ", product_type='" + product_type + '\'' +
                ", product_name='" + product_name + '\'' +
                ", sub_product_name='" + sub_product_name + '\'' +
                ", main_picture_num=" + main_picture_num +
                ", carousel_figure_num=" + carousel_figure_num +
                ", first_category_name='" + first_category_name + '\'' +
                ", secondary_category_name='" + secondary_category_name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", group='" + group + '\'' +
                ", label='" + label + '\'' +
                ", good_specification='" + good_specification + '\'' +
                ", peck_gift_good_code='" + peck_gift_good_code + '\'' +
                ", product_spec='" + product_spec + '\'' +
                ", product_spec_item='" + product_spec_item + '\'' +
                ", spec_picture__num=" + spec_picture__num +
                ", selling_price=" + selling_price +
                ", original_price=" + original_price +
                ", cost_price=" + cost_price +
                ", stock=" + stock +
                ", stock_warning=" + stock_warning +
                ", product_code='" + product_code + '\'' +
                ", product_sn='" + product_sn + '\'' +
                ", stock_hide='" + stock_hide + '\'' +
                ", virtual_sales=" + virtual_sales +
                ", sales_hide='" + sales_hide + '\'' +
                ", dispatch_mode='" + dispatch_mode + '\'' +
                ", express_price='" + express_price + '\'' +
                ", express_template='" + express_template + '\'' +
                ", auto_warehouse_time='" + auto_warehouse_time + '\'' +
                ", status='" + status + '\'' +
                ", is_buy_num_limit='" + is_buy_num_limit + '\'' +
                ", min_buy=" + min_buy +
                ", max_buy_total=" + max_buy_total +
                ", browse_authority='" + browse_authority + '\'' +
                ", buy_authority='" + buy_authority + '\'' +
                ", join_member_discount='" + join_member_discount + '\'' +
                ", promotion_diagram_name='" + promotion_diagram_name + '\'' +
                ", promotion_diagram_link='" + promotion_diagram_link + '\'' +
                ", promotion_diagram_degree='" + promotion_diagram_degree + '\'' +
                ", detailed_diagram_num=" + detailed_diagram_num +
                ", authorize_diagram_name='" + authorize_diagram_name + '\'' +
                ", common_diagram_name='" + common_diagram_name + '\'' +
                ", activity_name='" + activity_name + '\'' +
                ", activity_start_time='" + activity_start_time + '\'' +
                ", activity_end_time='" + activity_end_time + '\'' +
                ", activity_channel='" + activity_channel + '\'' +
                ", activity_object='" + activity_object + '\'' +
                ", member_degree='" + member_degree + '\'' +
                ", credit=" + credit +
                ", allow_accumulate='" + allow_accumulate + '\'' +
                '}';
    }
}
