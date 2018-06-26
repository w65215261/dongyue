//window.onload=function ()
//{
//	createAccordion('show1');
//	//(function (){
//	//	var oS=document.createElement('script');
//	//    var ab;
//	//	oS.type='text/javascript';
//	//	oS.src='';
//	//
//	//	document.body.appendChild(oS);
//	//})();
//};

function createAccordion(id)
{
	var oDiv=document.getElementById(id);
	var iMinWidth=9999999;
	
	var aLi=oDiv.getElementsByTagName('li');
	var aSpan=oDiv.getElementsByTagName('span');
	
	var i=0;
	
	oDiv.timer=null;
	
	for(i=0;i<aSpan.length;i++)
	{
		aSpan[i].index=i;
        aSpan[i].onmouseover=function ()
        {
            gotoImg(oDiv, this.index, iMinWidth);
            $("#kn"+ this.index).fadeIn(2000);
            var c=document.getElementById(id);
            var b=c.getElementsByTagName('span');
            var i=0;
            for(i=0;i<b.length;i++)
            {
                if(i!=this.index)
                {$("#kn"+ i).fadeOut(2000);
                }

            }


        };
		//aSpan[i].onclick=function ()
		//{
		//	gotoImg(oDiv, this.index, iMinWidth);
		//	$("#kn"+ this.index).fadeIn(2000);
		//	var c=document.getElementById(id);
		//	var b=c.getElementsByTagName('span');
		//	var i=0;
		//	for(i=0;i<b.length;i++)
		//	{
		//		if(i!=this.index)
		//		{$("#kn"+ i).fadeOut(2000);
		//			}
		//
		//		}
		//
		//
		//};
		
		iMinWidth=Math.min(iMinWidth, aLi[i].offsetWidth);
		
		
	}
	
};

function gotoImg(oDiv, iIndex, iMinWidth)
{
	if(oDiv.timer)
	{
		clearInterval(oDiv.timer);	
	}
	oDiv.timer=setInterval
	(
		function ()
		{
			changeWidthInner(oDiv, iIndex, iMinWidth);
		}, 30
	);
}

function changeWidthInner(oDiv, iIndex, iMinWidth)
{
	var aLi=oDiv.getElementsByTagName('li');
	var aSpan=oDiv.getElementsByTagName('span');
	var iWidth=oDiv.offsetWidth;
	var w=0;
	var bEnd=true;
	var i=0;
	
	for(i=0;i<aLi.length;i++)
	{
		if(i==iIndex)
		{
			continue;
		}
		
		if(iMinWidth==aLi[i].offsetWidth)
		{
			iWidth-=iMinWidth;
			continue;			
		}
		
		bEnd=false;
		
		speed=Math.ceil((aLi[i].offsetWidth-iMinWidth)/10);
		
		w=aLi[i].offsetWidth-speed;
		
		if(w<=iMinWidth)
		{
			w=iMinWidth;
			
		}
		
		aLi[i].style.width=w+'px';
				
		iWidth-=w;
		
	  $(aLi[i]).find(".sfn").hide();
	  $(aLi[i]).find("span").show();
	}
	
	aLi[iIndex].style.width=iWidth+'px';	
		$(aLi[iIndex]).find(".sfn").show();
		$(aLi[iIndex]).find("span").hide();
	
	if(bEnd)
	{
		clearInterval(oDiv.timer);		
		//$(oDiv).find(".sfn").hide();
		//$(ab).find(".sfn").show();
		oDiv.timer=null;
		
	}
}