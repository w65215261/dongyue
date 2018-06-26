/**
 * Created by Leon on 16/9/6.
 */
var global_val = global_sub_val = 1;
var orderValidate = new Object();

orderValidate.modify_ticket_num = function(){

    $('.ticket_num').on('keydown', function(){
        global_val = $(this).val();
    });
    //验证数量文本框只能填写数字
    $('.ticket_num').on('keyup', function(event){
        var val = $(this).val();
        if(event.keycode != 13) {
            if (isNaN(val)) {
                alert('请输入正确的门票数量');
                $(this).val(global_val);
            }
            else if(val == '' || typeof(val) == 'undefined'){
                $(this).val(1);
            }
            else if (/\.+/.test(val)) {
                alert('请输入整数');
                $(this).val(global_val);
            }
            else{
                sum_unit_price($(this), val);
            }
        }
    });

    //减号
    $('.ticket_minus').on('click',function(){
        var number = $(this).siblings('input[type=text]').val();
        if(!isNaN(parseInt(number)) && parseInt(number) > 1){
            number = parseInt(number) - 1;
            $('.sub_ticket_minus').click();
        }
        $(this).siblings('input[type=text]').val(number);
        sum_unit_price($(this), number);
    });
    //加号
    $('.ticket_plus').on('click',function(){
        var number = $(this).siblings('input[type=text]').val();
        if(!isNaN(parseInt(number)) && parseInt(number) >= 0){
            number = parseInt(number) + 1;
        }
        $(this).siblings('input[type=text]').val(number);
        sum_unit_price($(this), number);
    });
};

orderValidate.init = function(){
    this.modify_ticket_num();
    sum_total_price();
};


function sum_unit_price (obj, number) {
    var unit_price = style_price($(obj).siblings('input.ticket_price').val()*1*number);
    $(obj).parents('.dx_fo').find('dl.dl1').find('.ticket_price_panel').empty().append(unit_price);
    sum_total_price();
}
function sum_total_price(){
    var total_price = 0;
    $('.ticket_price_panel').each(function(){
        var ticket_price = filter_price($(this).html());
        if(!isNaN(ticket_price)){
            total_price += ticket_price*1;
        }
    });
    $('.total_ticket_price_panel').empty().append(style_price(total_price));
}

function filter_price(price){
    return price.replace('¥ ', '');
}
function style_price(price){
    return '¥ ' + parseFloat(price).toFixed(2);
}