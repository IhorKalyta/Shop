<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<!-- FlexSlider -->
            <script src="/resources/js/imagezoom.js"></script>
              <script defer src="/resources/js/jquery.flexslider.js"></script>
            <link rel="stylesheet" href="/resources/css/flexslider.css" type="text/css" media="screen" />

            <script>
            // Can also be used with $(document).ready()
            $(window).load(function() {
              $('.flexslider').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
              });
            });
            </script>
        <!-- //FlexSlider-->
	
<div class="head-bread">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			
			<li class="active">Shop</li>
		</ol>
	</div>
</div>

<div class="showcase-grid">
            <div class="container">
            
                <div class="col-md-8 showcase">
                    <div class="flexslider">
                         
                            <div class="img">
                             
						<img
							src="/images/product/${product.id}${product.path}?version=${product.version}"
							class="img-responsive gri-wid" width="500">
							
					</div>
                            
                          
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="col-md-4 showcase">
                    <div class="showcase-rt-top">
                    
                        <div class="pull-left shoe-name">
                       
                            <h3>${product.name}</h3>
                            
                            <h4>&#36;${product.price}</h4> 
                          
                        </div>
                       
                        
                        <div class="clearfix"></div>
                    </div>
                    <hr class="featurette-divider">
                    <div class="shocase-rt-bot">
                        <div class="float-qty-chart">
                        <ul>
                            <li class="qty">
                                <h3>Size</h3>
                                <select class="form-control siz-chrt">
                                  <option> ${product.size}</option>
                                 
                                </select>
                            </li>
                            <li class="qty">
                                <h4>QTY</h4>
                                <select class="form-control qnty-chrt">
                                  <option>1</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                  <option>6</option>
                                  <option>7</option>
                                </select>
                            </li>
                        </ul>
                        
                        </div>
                        <div class="clearfix"></div>
                        <ul>
                            <li class="ad-2-crt simpleCart_shelfItem">
                                <a class="btn item_add" href="#" role="button">Add To Cart</a>
                                <a class="btn" href="#" role="button">Buy Now</a>
                            </li>
                        </ul>
                    </div>
                    <div class="showcase-last">
                        <h3>product details</h3>
                        <ul>
                            <li>${product.description}</li>
        
                        </ul>
                    </div>
                </div>
        <div class="clearfix"></div>
       
            </div>
        </div>
        
         <div class="specifications">
            <div class="container">
              <h3>Item Details</h3> 
                <div class="detai-tabs">
                    <!-- Nav tabs -->
                    <ul class="nav nav-pills tab-nike" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Highlights</a></li>
                    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Description</a></li>
                    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Terms and conditionals</a></li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">
                    <p>The full-length Max Air unit delivers excellent cushioning with enhanced flexibility for smoother transitions through footstrike.</p> 
                    <p>Dynamic Flywire cables integrate with the laces and wrap your midfoot for a truly adaptive, supportive fit.</p>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile">
                    <p>${product.description}</p>    
                    </div>
                    <div role="tabpanel" class="tab-pane" id="messages">
                        The images represent actual product though color of the image and product may slightly differ.    
                    </div>
                    </div>
                </div>
            </div>
        </div>