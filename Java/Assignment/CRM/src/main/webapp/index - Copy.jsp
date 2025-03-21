<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>C R M</title>
    <link rel="apple-touch-icon" sizes="57x57" href="assets/images/favicons/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="assets/images/favicons/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="assets/images/favicons/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="assets/images/favicons/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="assets/images/favicons/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="assets/images/favicons/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="assets/images/favicons/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="assets/images/favicons/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="assets/images/favicons/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="assets/images/favicons/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/images/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/images/favicons/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicons/favicon-16x16.png">
    <link rel="manifest" href="/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="assets/images/favicons/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!--  Style sheets =============================================-->
    <!-- Default style sheets-->
    <link href="assets/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template specific style sheets-->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Volkhov:400i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="assets/lib/animate.css/animate.css" rel="stylesheet">
    <link href="assets/lib/components-font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/lib/et-line-font/et-line-font.css" rel="stylesheet">
    <link href="assets/lib/flexslider/flexslider.css" rel="stylesheet">
    <link href="assets/lib/owl.carousel/dist/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css" rel="stylesheet">
    <link href="assets/lib/magnific-popup/dist/magnific-popup.css" rel="stylesheet">
    <link href="assets/lib/simple-text-rotator/simpletextrotator.css" rel="stylesheet">
    <!-- Main stylesheet and color file-->
    <link href="assets/css/style.css" rel="stylesheet">
    <link id="color-scheme" href="assets/css/colors/default.css" rel="stylesheet">
  </head>
  <body data-spy="scroll" data-target=".onpage-navigation" data-offset="60">
    <main>
      <div class="page-loader">
        <div class="loader">Loading...</div>
      </div>
      <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#custom-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a class="navbar-brand" href="index.jsp">Customer Relationship Management</a>
          </div>
          <div class="collapse navbar-collapse" id="custom-collapse">
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Home</a>
                <!-- <ul class="dropdown-menu">
                  <li><a href="index_mp_fullscreen_video_background.jsp">Default</a></li>
                  <li><a href="index_op_fullscreen_gradient_overlay.jsp">One Page</a></li>
                  <li><a href="index_agency.jsp">Agency</a></li>
                  <li><a href="index_restaurant.jsp">Restaurant</a></li>
                  <li><a href="index_finance.jsp">Finance</a></li>
                  <li><a href="index_landing.jsp">Landing Page</a></li>
                  <li><a href="index_photography.jsp">Photography</a></li>
                </ul> -->
              </li>
              <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Customers</a>
                <ul class="dropdown-menu">
                  <li class="dropdown"><a href="ManageFeedback.jsp">Manage Feedback</a></li>
                  <li class="dropdown"><a href="ManageQuery.jsp">Manage Query</a></li>
                  <li class="dropdown"><a href="listProject.jsp">View Project</a></li>
                  <li class="dropdown"><a href="Profile.jsp">Manage Profile</a></li>
                  <li class="dropdown"><a href="ResetPassword.jsp">Reset Password</a></li>
                </ul>
              </li>
              <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">BDE</a>
                <ul class="dropdown-menu">
                  <li class="dropdown"><a href="InviteCustomer.jsp">Invite Customer</a></li>
                  <li class="dropdown"><a href="ManageCustomer.jsp">Manage Customer</a></li>
                  <li class="dropdown"><a href="ManageProject.jsp">Manage Project</a></li>
                  <li class="dropdown"><a href="ManageFeedback.jsp">View Feedback</a></li>
                  <li class="dropdown"><a href="ManageQuery.jsp">Reply Query</a></li>
                  <!-- <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Services</a>
                    <ul class="dropdown-menu">
                      <li><a href="service1.jsp">Service 1</a></li>
                      <li><a href="service2.jsp">Service 2</a></li>
                      <li><a href="service3.jsp">Service 3</a></li>
                    </ul>
                  </li> -->
                  <!-- <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Pricing</a>
                    <ul class="dropdown-menu">
                      <li><a href="pricing1.jsp">Pricing 1</a></li>
                      <li><a href="pricing2.jsp">Pricing 2</a></li>
                    </ul>
                  </li> -->
                  <!-- <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Gallery</a>
                    <ul class="dropdown-menu">
                      <li><a href="gallery_col_2.jsp">2 Columns</a></li>
                      <li><a href="gallery_col_3.jsp">3 Columns</a></li>
                      <li><a href="gallery_col_4.jsp">4 Columns</a></li>
                      <li><a href="gallery_col_6.jsp">6 Columns</a></li>
                    </ul>
                  </li> -->
                  <li class="dropdown"><a class="dropdown-toggle" href="contact2.jsp" data-toggle="dropdown">Contact</a>
                    <!-- <ul class="dropdown-menu">
                      <li><a href="contact1.jsp">Contact 1</a></li>
                      <li><a href="contact2.jsp">Contact 2</a></li>
                      <li><a href="contact3.jsp">Contact 3</a></li>
                    </ul> -->
                  </li>
                  <!-- <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Restaurant menu</a>
                    <ul class="dropdown-menu">
                      <li><a href="restaurant_menu1.jsp">Menu 2 Columns</a></li>
                      <li><a href="restaurant_menu2.jsp">Menu 3 Columns</a></li>
                    </ul>
                  </li> -->
                  <li><a href="login_register.jsp">Login / Register</a></li>
                  <!-- <li><a href="faq.jsp">FAQ</a></li>
                  <li><a href="404.jsp">Page 404</a></li> -->
                </ul>
              </li>
              
              <!-- <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Portfolio</a>
                <ul class="dropdown-menu" role="menu">
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Boxed</a>
                    <ul class="dropdown-menu">
                      <li><a href="portfolio_boxed_col_2.jsp">2 Columns</a></li>
                      <li><a href="portfolio_boxed_col_3.jsp">3 Columns</a></li>
                      <li><a href="portfolio_boxed_col_4.jsp">4 Columns</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Boxed - Gutter</a>
                    <ul class="dropdown-menu">
                      <li><a href="portfolio_boxed_gutter_col_2.jsp">2 Columns</a></li>
                      <li><a href="portfolio_boxed_gutter_col_3.jsp">3 Columns</a></li>
                      <li><a href="portfolio_boxed_gutter_col_4.jsp">4 Columns</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Full Width</a>
                    <ul class="dropdown-menu">
                      <li><a href="portfolio_full_width_col_2.jsp">2 Columns</a></li>
                      <li><a href="portfolio_full_width_col_3.jsp">3 Columns</a></li>
                      <li><a href="portfolio_full_width_col_4.jsp">4 Columns</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Full Width - Gutter</a>
                    <ul class="dropdown-menu">
                      <li><a href="portfolio_full_width_gutter_col_2.jsp">2 Columns</a></li>
                      <li><a href="portfolio_full_width_gutter_col_3.jsp">3 Columns</a></li>
                      <li><a href="portfolio_full_width_gutter_col_4.jsp">4 Columns</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Masonry</a>
                    <ul class="dropdown-menu">
                      <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Boxed</a>
                        <ul class="dropdown-menu">
                          <li><a href="portfolio_masonry_boxed_col_2.jsp">2 Columns</a></li>
                          <li><a href="portfolio_masonry_boxed_col_3.jsp">3 Columns</a></li>
                          <li><a href="portfolio_masonry_boxed_col_4.jsp">4 Columns</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Full Width</a>
                        <ul class="dropdown-menu">
                          <li><a href="portfolio_masonry_full_width_col_2.jsp">2 Columns</a></li>
                          <li><a href="portfolio_masonry_full_width_col_3.jsp">3 Columns</a></li>
                          <li><a href="portfolio_masonry_full_width_col_4.jsp">4 Columns</a></li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Hover Style</a>
                    <ul class="dropdown-menu">
                      <li><a href="portfolio_hover_black.jsp">Black</a></li>
                      <li><a href="portfolio_hover_gradient.jsp">Gradient</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Single</a>
                    <ul class="dropdown-menu">
                      <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Featured Image</a>
                        <ul class="dropdown-menu">
                          <li><a href="portfolio_single_featured_image1.jsp">Style 1</a></li>
                          <li><a href="portfolio_single_featured_image2.jsp">Style 2</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Featured Slider</a>
                        <ul class="dropdown-menu">
                          <li><a href="portfolio_single_featured_slider1.jsp">Style 1</a></li>
                          <li><a href="portfolio_single_featured_slider2.jsp">Style 2</a></li>
                        </ul>
                      </li>
                      <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Featured Video</a>
                        <ul class="dropdown-menu">
                          <li><a href="portfolio_single_featured_video1.jsp">Style 1</a></li>
                          <li><a href="portfolio_single_featured_video2.jsp">Style 2</a></li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li> -->
              
                                       
            </ul>
          </div>
        </div>
      </nav>
      <section class="bg-dark-30 showcase-page-header module parallax-bg" data-background="assets/images/showcase_bg.jpg">
        <div class="titan-caption">
          <div class="caption-content">
            <div class="font-alt mb-30 titan-title-size-1">Good customer relations equals success</div>
            <div class="font-alt mb-40 titan-title-size-4">Get closer to your customer</div>
            <!-- <a class="section-scroll btn btn-border-w btn-round" href="#demos">See Demos</a> -->
          </div>
        </div>
      </section>
      <div class="main showcase-page">
        <section class="module-extra-small bg-dark">
          <div class="container">
            <div class="row">
              <div class="col-sm-6 col-md-8 col-lg-9">
                <div class="callout-text font-alt">
                  <h4 style="margin-top: 0px; font-;">Start Creating Beautiful Websites</h4>
                  <p style="margin-bottom: 0px;">Download Titan Free today!</p>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3">
                <div class="callout-btn-box"><a class="btn btn-border-w btn-circle" href="https://themewagon.com/themes/titan/">Downlaod Free</a></div>
              </div>
            </div>
          </div>
        </section>
        <section class="module-medium" id="demos">
          <div class="container">
            <div class="row multi-columns-row">
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_mp_fullscreen_video_background.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/main_demo.jpg" alt="Main Demo"></div>
                  <h3 class="content-box-title font-serif">Main Demo</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_agency.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/agency.jpg" alt="Agency"></div>
                  <h3 class="content-box-title font-serif">Agency</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_portfolio.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/portfolio.jpg" alt="Portfolio"></div>
                  <h3 class="content-box-title font-serif">Portfolio</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_restaurant.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/restaurant.jpg" alt="Restaurant"></div>
                  <h3 class="content-box-title font-serif">Restaurant</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_finance.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/finance.jpg" alt="Finance"></div>
                  <h3 class="content-box-title font-serif">Finance</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_landing.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/landing.jpg" alt="Landing"></div>
                  <h3 class="content-box-title font-serif">Landing</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_photography.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/photography.jpg" alt="Photography"></div>
                  <h3 class="content-box-title font-serif">Photography</h3></a></div>                  
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_op_fullscreen_gradient_overlay.jsp">
                  <div class="content-box-image"><img src="assets/images/screenshots/one_page.jpg" alt="One Page"></div>
                  <h3 class="content-box-title font-serif">One Page</h3></a></div>
            </div>
          </div>
        </section>
        <section class="module-extra-small bg-dark">
          <div class="container">
            <div class="row">
              <div class="col-sm-6 col-md-8 col-lg-9">
                <div class="callout-text font-alt">
                  <h4 style="margin-top: 0px;">Start Creating Beautiful Websites</h4>
                  <p style="margin-bottom: 0px;">Download Titan Free today!</p>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3">
                <div class="callout-btn-box"><a class="btn btn-border-w btn-circle" href="https://themewagon.com/themes/titan/">Downlaod Free</a></div>
              </div>
            </div>
          </div>
        </section>
      </div>
      <div class="scroll-up"><a href="#totop"><i class="fa fa-angle-double-up"></i></a></div>
    </main>
    <!--  
    JavaScripts
    =============================================
    -->
    <script src="assets/lib/jquery/dist/jquery.js"></script>
    <script src="assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/lib/wow/dist/wow.js"></script>
    <script src="assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js"></script>
    <script src="assets/lib/isotope/dist/isotope.pkgd.js"></script>
    <script src="assets/lib/imagesloaded/imagesloaded.pkgd.js"></script>
    <script src="assets/lib/flexslider/jquery.flexslider.js"></script>
    <script src="assets/lib/owl.carousel/dist/owl.carousel.min.js"></script>
    <script src="assets/lib/smoothscroll.js"></script>
    <script src="assets/lib/magnific-popup/dist/jquery.magnific-popup.js"></script>
    <script src="assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
  </body>
</html>
