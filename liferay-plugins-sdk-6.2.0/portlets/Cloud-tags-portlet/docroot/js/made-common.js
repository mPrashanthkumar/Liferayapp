$(document).ready(function(){
	
	function swipe_left_main() 
		{
			$('.carousel-stage').jcarousel('scroll', '+=1');
		}
	function swipe_right_main() 
		{
			$('.carousel-stage').jcarousel('scroll', '-=1');
		}
		
	function swipe_left_thumb() 
		{
			$('.carousel-navigation').jcarousel('scroll', '+=1');
		}
	function swipe_right_thumb() 
		{
			$('.carousel-navigation').jcarousel('scroll', '-=1');
		}
		
	function swipe_left_customer() 
		{
			$('.jcarousel').jcarousel('scroll', '+=1');
		}
	function swipe_right_customer() 
		{
			$('.jcarousel').jcarousel('scroll', '-=1');
		}	
			
	$('.carousel-stage').touchwipe({
	  wipeLeft: function() {
	   swipe_left_main();
	  },
	  wipeRight: function() {
		swipe_right_main();
	  },
	  min_move_x: 20,
	  min_move_y: 20,
	  preventDefaultEvents: false
	});
	
	
	$('.carousel-navigation').touchwipe({
	  wipeLeft: function() {
	   swipe_left_thumb();
	  },
	  wipeRight: function() {
		swipe_right_thumb();
	  },
	  min_move_x: 20,
	  min_move_y: 20,
	  preventDefaultEvents: false
	});
	
	$('.jcarousel').touchwipe({
	  wipeLeft: function() {
	   swipe_left_customer();
	  },
	  wipeRight: function() {
		swipe_right_customer();
	  },
	  min_move_x: 20,
	  min_move_y: 20,
	  preventDefaultEvents: false
	});
	
});	




$(document).ready(function(){



/*$("#myPopup_main").hide();
$("#myPopup").hide();
$("#close").hide();*/
	$("#save").hide();
$("#popup").click(function(){
	$("#myPopup_main").show();
	$("#myPopup").show();
	$("#close").show();
	//$("#save").show();
	$('body').css('position','fixed');
	$('body').css('overflow-y','hidden');
	$('body').css('overflow-x','hidden');
});
	
$("#close").click(function(){
	$("#myPopup_main").hide();
	$("#myPopup").hide();
	$("#close").hide();
	$("#save").hide();
	$("#saveOnLoad").hide();
	$('body').css('position','fixed');
	$('body').css('overflow-y','scroll');
	$('body').css('overflow-x','hidden');
});

/*$("#save").click(function(){
	$("#myPopup_main").hide();
	$("#myPopup").hide();
	$("#close").hide();
	$("#save").hide();
	$('body').css('position','fixed');
	$('body').css('overflow-y','scroll');
	$('body').css('overflow-x','hidden');
});*/

$("#myPopup_main").click(function(){
	$("#myPopup_main").hide();
	$("#myPopup").hide();
	$("#close").hide();
	$("#save").hide();
	$("#saveOnLoad").hide();
	$('body').css('position','fixed');
	$('body').css('overflow-y','scroll');
	$('body').css('overflow-x','hidden');
});



});	







$(document).ready(function(){
	$("#remove_main").hide();
	$("#remove").hide();
	//$(".cart_remove").hide();
	//$(".cart_list_highlight_btn").hide();

	
	/*$(".cart_remove").click(function(){
		remove_popup();
	});*/
	
	$(".remove_close").click(function(){
		remove_popup_close();
	});
	$(".remove_no").click(function(){
		remove_popup_close();
	});
	
	$("#remove_main").click(function(){
		remove_popup_close();
	});
	
	/*$(".cart_list").click(function(){
		cart_highlight();
	});*/
	
		function cart_highlight() 
		{
			/*$(".cart_list").css('border','#dddee0 solid 1px');
			$(".cart_list").css('border-top-right-radius','14px');
			$(".cart_remove").show();
			$(".cart_list_highlight_btn").show();*/
		}

		
		function remove_popup()
		{
			$("#remove_main").show();
			$("#remove").show();
			$('body').css('position','fixed');
			$('body').css('overflow-y','hidden');
			$('body').css('overflow-x','hidden');
		}
		
		function remove_popup_close()
		{
			$("#remove_main").hide();
			$("#remove").hide();
			$('body').css('position','fixed');
			$('body').css('overflow-y','scroll');
			$('body').css('overflow-x','hidden');
		}
		
		
		
		
		function remove_li(li_id)
		{
			
			if (li_id == "add_item") {
				$('li#add_item').remove();
			} else if (li_id == "wow") {
				$('li#wow').remove();
			} else if (li_id == "congrats"){
				$('li#congrats').remove();
			}
			
			
			//$('ul#trash').find('li#add_item').;
		}
		
		
		function add_li(ul_id, index)
		{
			//add_item add
			if (ul_id == "add_item") {
				$('ul#trash').append('<li id="add_item"><div class="cart_list"> <a id="popup" href="#hints" data-rel="popup" data-position-to="window" data-transition="none"><div class="cart_list_image" style="background:url(images/add_item.jpg) no-repeat; background-size:contain;"></div></a> <div class="cart_list_image_heading" style="display:none;"> Richie<br/> 3 seater sofa </div><div class="cart_note" style="display:none;"><a href="#note"><img src="images/note.jpg" alt="note"></a></div><div class="cart_remove" style="display:none;"><img src="images/remove.jpg" alt="note"></div></div></li>');				
			//wow item add
			} else if (ul_id == "wow") {
				$('ul#trash').append('<li id="wow" style="display:block;"><div class="cart_list"> <div class="cart_instruction_heading">WOW!</div><div class="cart_instruction"> Quite a list you have<br/> here! Take it home<br/> via email. </div><div class="wow_btn">EMAIL MY LIST</div><div class="cart_list_image_heading" style="display:none;"> Richie<br/> 3 seater sofa </div><div class="cart_note" style="display:none;"><a href="#note"><img src="images/note.jpg" alt="note"></a></div><div class="cart_remove" style="display:none;"><img src="images/remove.jpg" alt="note"></div></div></li>');
			//congrats item add
			} else if (ul_id == "congrats") {
				$('ul#trash').append('<li id="congrats"><div class="cart_list"> <div class="cart_instruction_heading">CONGRATS!</div><div class="cart_instruction"> You have added an<br/> item to your collection<br/><br/> Tap another icon or<br/> add items from the<br/> area below </div><div class="cart_list_image_heading" style="display:none;"> Richie<br/> 3 seater sofa </div><div class="cart_note" style="display:none;"><a href="#note"><img src="images/note.jpg" alt="note"></a></div><div class="cart_remove" style="display:none;"><img src="images/remove.jpg" alt="note"></div></div></li>');							
			}
		}
		
		
		//$("#congrats").click(function(){
//			remove_li("congrats");
//		});
//		
//		$("#wow").click(function(){
//			remove_li("wow");
//		});
		
	
	
});	








/////////////////////////////////////////
// used to hide loading 

/////////////////////////////////////////
// used to hide added 
function hide_added() {
 $('#added').delay(600).fadeOut(300);
}

// used to show added 
function show_added() {
$('#added').css('display','block');
 $('#added').css('z-index','10000');
 $('#added').fadeIn('fast');
 
}
/////////////////////////////////////////
// used to hide removed 
function hide_removed() {
 $('#removed').delay(600).fadeOut(300);
}
// used to show removed 
function show_removed() {
 $('#removed').fadeIn('fast');
}
////////////////////////////////////////

$(document).ready(function(){
	
	$("#email_container_overlay").hide();
	$("#email_container").hide();
	$(".thankyou_heading").hide();
	$(".thankyou_btn").hide();
	$("#thankyou_close").hide();
	$("#clear").hide();
	
    $("#header_logo").click(function(){
        $("#email_container").show();
		$("#email_container_overlay").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		emailAddessInput();
//		$("#product_header").hide();
//		$(".cart_top_heading").hide();
    });
    
    $(".wow_btn").click(function(){
        $("#email_container").show();
		$("#email_container_overlay").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		emailAddessInput();
//		$("#product_header").hide();
//		$(".cart_top_heading").hide();
    });
    
	/*$("#email_container_overlay").click(function(){
		$("#email_container_overlay").hide();
		$("#email_container").hide();
		$("#clear").hide();
		$("#finish").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','scroll');
		$('body').css('overflow-x','hidden');
	});*/

	
	$(".finish_btn").click(function(){
        $("#email_container").show();
		$("#email_container_overlay").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		emailAddessInput();
//		$("#product_header").hide();
//		$(".cart_top_heading").hide();
    });
	
	$("#wow_btn").click(function(){
        $("#email_container").show();
		$("#email_container_overlay").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		$("#product_header").hide();
		$(".cart_top_heading").hide();
    });
	
	$("#header_email").click(function(){
        $("#email_container").show();
		$("#email_container_overlay").show();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
//		$("#product_header").hide();
//		$(".cart_top_heading").hide();
		emailAddessInput();
    });
	
	/*$(".email_btn").click(function(){
        $(".email_heading").hide();
		$(".email_field").hide();
		$(".email_btn").hide();
		$("#email_close").hide();
		
		$(".thankyou_heading").show();
		$(".thankyou_btn").show();
		$("#thankyou_close").show();
		$("#finish").hide();
		$("#clear").show();
    });*/
	
	$("#email_close").click(function(){
		//alert("<<<<<<<EMAIL-CLOSE>>>>>");
		$("#clear").css("display","none");
		$("#finish").css("display","block");	
        $("#email_container").hide();
		$("#email_container_overlay").hide();	
		$('body').css('position','fixed');
		$('body').css('overflow-y','scroll');
		$('body').css('overflow-x','hidden');
		$("#product_header").show();
//		$(".cart_top_heading").show();
    });
	
	$(".cart_list_bottom").click(function(){
        $("#email_container").hide();
		$("#email_container_overlay").hide();
		$('body').css('position','fixed');
		$('body').css('overflow-y','scroll');
		$('body').css('overflow-x','hidden');
		$("#product_header").show();
//		$(".cart_top_heading").show();
    });
	
	$("#thankyou_close").click(function(){
        $("#email_container").hide();
		$("#email_container_overlay").hide();
		$('body').css('position','fixed');
		$('body').css('overflow-y','scroll');
		$('body').css('overflow-x','hidden');
		$("#product_header").show();
//		$(".cart_top_heading").show();
    });
});

//$(function() {
//    // there's the gallery and the trash
//    var $gallery = $( "#gallery" ),
//      $trash = $( "#trash" );
// 
//    // let the gallery items be draggable
//    $( "li", $gallery ).draggable({
//	  appendTo: "body",	
//      cancel: "a.ui-icon", // clicking an icon won't initiate dragging
//      revert: "invalid", // when not dropped, the item will revert back to its initial position
//      containment: "document",
//      cursor: "move",
//      scroll: false,
//	  delay: 1000,
//	  distance: 20,
//	  helper: "clone",
//	  /*start: function(){
//        $(this).hide();             
//    },
//    stop: function(){
//        $(this).show()
//    }*/
//    });
//	
//    // let the trash be droppable, accepting the gallery items
//    $trash.droppable({
//      accept: "#gallery > li",
//	  revert: "invalid",
//      activeClass: "ui-state-highlight",
//      drop: function( event, ui ) {
//		  //$( "#add_item" ).remove();
//		  alert("Add item image will hide while dropping in integration time");
//		  $("#cart-drop1").html('<a data-transition="fade" data-position-to="window" data-rel="popup" href="#myPopup" id="popup" aria-haspopup="true" aria-owns="myPopup" aria-expanded="false" class="ui-link"><div style="background:url(images/edit1.jpg) no-repeat; background-size:contain;" class="cart_list_image"></div></a> <div class="cart_list_image_heading"> Richie<br>3 seater sofa </div><div class="cart_note"> <a data-transition="fade" data-position-to="origin" data-rel="popup" href="#note" aria-haspopup="true" aria-owns="note" aria-expanded="false" class="ui-link"> <img alt="note" src="images/note.jpg" id="note_normal"><img alt="note" src="images/note_active_new.jpg" id="note_active_new" style="display: none;"></a> </div><div class="cart_remove"><img src="images/remove.jpg" alt="note"></div>');
//		  
//        deleteImage( ui.draggable );
//		
//		//$( '<li id="add_item"><div class="cart_list"> <a id="popup" href="#hints" data-rel="popup" data-position-to="window" data-transition="fade"><div class="cart_list_image" style="background:url(images/add_item.jpg) no-repeat; background-size:contain;"></div></a></li>' ).appendTo( $trash ); 
//		 
//      }
//    });
// 
//    // let the gallery be droppable as well, accepting items from the trash
//    $gallery.droppable({
//	  revert: invalid,	
//      accept: "#trash li",
//      activeClass: "custom-state-active",
//      drop: function( event, ui ) {
//        recycleImage( ui.draggable );
//      }
//    });
// 
//    // image deletion function
//    var recycle_icon = "";
//    function deleteImage( $item ) {
//      $item.fadeOut(function() {
//        var $list = $( "ul", $trash ).length ?
//          $( "ul", $trash ) :
//          $( "<li class='gallery ui-helper-reset'/>" ).appendTo( $trash );
// 		
//        $item.find( "a.ui-icon-trash" ).remove();
//        $item.append( recycle_icon ).appendTo( $list ).fadeIn(function() {
//          $item
//            .animate()
//            .find( "img" )
//              .animate();
//        });
//      });
//    }
// 
//    // image recycle function
//    var trash_icon = "";
//    function recycleImage( $item ) {
//      $item.fadeOut(function() {
//        $item
//          .find( "a.ui-icon-refresh" )
//            .remove()
//          .end()
//          .css( "width", "0px")
//          .append( trash_icon )
//          .find( "img" )
//            .css( "height", "0px" )
//          .end()
//          .appendTo( $gallery )
//          .fadeIn();
//      });
//    }
//  });









if($(window).width() > 768){

// Hide all but first tab content on larger viewports
$('.accordion__content:not(:first)').hide();

// Activate first tab
$('.accordion__title:first-child').addClass('active');

} else {
  
// Hide all content items on narrow viewports
$('.accordion__content').hide();
};

// Wrap a div around content to create a scrolling container which we're going to use on narrow viewports
$( ".accordion__content" ).wrapInner( "<div class='overflow-scrolling'></div>" );

// The clicking action
$('.accordion__title').on('click', function() {
$('.accordion__content').hide();
$(this).next().show().prev().addClass('active').siblings().removeClass('active');
});
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");


	$("#customer_popup_main").hide();
	$("#customer_popup").hide();
	$("#loader").hide();
	
    $("#customer_img1").click(function(){
        $("#customer_popup_main").show();
		$("#customer_popup").show();
    });
	
	$("#customer_popup_close").click(function(){
		$("#customer_popup_main").hide();
        $("#customer_popup").hide();
    });
	
	$("#customer_popup_main").click(function(){
        $("#customer_popup_main").hide();
		$("#customer_popup").hide();
    });
	
	$("#popup").click(function(){
        $("#customer_popup_main").hide();
		$("#customer_popup").hide();
		$('#myPopup').css('overflow-y','scroll');
		$('#myPopup').css('overflow-x','hidden');
    });
	function emailAddessInput(){
		$(".email_heading").show();
		$(".email_field").show();
		$(".email_btn").show();
		$("#email_close").show();
		
		$(".thankyou_heading").hide();
		$(".thankyou_btn").hide();
		$("#thankyou_close").hide();
		$("#finish").show();
		$("#clear").hide();
	}
	