var sybanlength=0;
var sybanindex=0;
var sybanid;

window.onresize = aa;
function aa(){
    /*$('#scroll_box').css('height',$(window).height()+'px');*/
}
$(function(){
	/*$('#scroll_box').css('height',$(window).height()+'px');*/
	$('.m4').click(function(){
		$('body,html').animate({scrollTop:($('#scroll_box').height()-50)},1500); 
		return false; 
	});
	$('.lb13 li').hover(function(){
		$(this).find('.limask').css('opacity','0.5');	
	},function(){
		$(this).find('.limask')	.css('opacity','0');	
	});
	
	$('.image').eq(0).css('opacity','1');
	
	sybanlength=$('.image').length;
	
	sybanid = setInterval('sybananimate()',6000);
	for(i=0;i<sybanlength;i++)
	{
		if(i==0)
		{
			$('.scroll_xnav2').append('<li class="current"></li>');	
		}
		else
		{
			$('.scroll_xnav2').append('<li></li>');	
		}
			
	}
	$('.scroll_xnav2>li').click(function(){
		clearInterval(sybanid);
		if($(this).attr('class')!='current')
		{
			$('.scroll_xnav2 li').removeClass('current');
			$(this).addClass('current');
			$('.image').eq(sybanindex).animate({'opacity':'0'},3000);
			sybanindex=$(this).index();
			$('.image').eq(sybanindex).animate({'opacity':'1'},3000);	
		}
		else
		{
			return false;	
		}
		sybanid = setInterval('sybananimate()',6000);	
	})
	
})

function sybananimate()
{
	$('.scroll_xnav2 li').removeClass('current');
	$('.image').eq(sybanindex).animate({'opacity':'0'},3000);
	sybanindex++;
	if(sybanindex>=sybanlength)
	{
		sybanindex=0;	
	}
	$('.image').eq(sybanindex).animate({'opacity':'1'},3000);
	$('.scroll_xnav2 li').eq(sybanindex).addClass('current');
}




