/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-01 08:44:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class payResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<!-- 网站头像 -->\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"/static/css/iconfont.css\">\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"/static/css/common.css\">\r\n");
      out.write("\t\t<!--整站改色 _start-->\r\n");
      out.write("\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"/static/css/color-style.css\">\r\n");
      out.write("\t\t<!--整站改色 _end-->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/static/css/layer.css\" id=\"layuicss-skinlayercss\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/static/css/flow.css\">\r\n");
      out.write("<title>支付结果 - 易购网</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"header login-header w990\">\r\n");
      out.write("\t\t\t<div class=\"logo-info\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\" onclick=\"goHome()\" class=\"logo\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/static/css/mall_logo_0.png\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<span class=\"findpw\">支付中心</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div class=\"content-bg\">\r\n");
      out.write("\t\t<div class=\"content-main w990\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 底部 -->\r\n");
      out.write("\t\t<div class=\"site-footer\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"footer-desc-copyright\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p class=\"footer-ecscinfo\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">首页</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">隐私保护</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">联系我们</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">免责条款</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">公司简介</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">意见反馈</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\t\t\t\t\t<a rel=\"nofollow\"  href=\"#\">会员登录</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\t\t\t\t\t<a rel=\"nofollow\"  href=\"http://bbs.yaorange.cn/\">会员论坛</a>\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" rel=\"nofollow\">客服热线028-86261949</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"footer-otherlink\">\r\n");
      out.write("\t\t\t\t\t<a title=\"易购商城\"  href=\"http://yaorange.cn\">易购商城</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a title=\"菁鱼课堂\"  href=\"http://www.yaorange.cn\">菁鱼课堂</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a title=\"资讯速递\"  href=\"http://www.yaorange.cn\">资讯速递</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a title=\"快递查询\"  href=\"http://m.kuaidi100.com\">快递查询</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a title=\"论坛\"  href=\"http://bbs.yaorange.com/forum.php\">会员论坛</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t|\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<a title=\"易购网\"  href=\"http://www.yaorange.cn\">易购网</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p class=\"footer-beian\"> ICP备案证书号:\r\n");
      out.write("\t\t\t\t\t<a rel=\"nofollow\"  href=\"#\">蜀ICP备88888888号-1</a>\r\n");
      out.write("\t\t\t\t\t<a rel=\"nofollow\"  href=\"#\"><i></i>蜀公网安备 45323525326664号</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"footer-Copyright\">Copyright &copy; 2017\r\n");
      out.write("\t\t\t\t\t<a  style=\"margin:0;padding:0;\" href=\"http://www.yaorange.com/\">yaorange.cn</a> All Rights Reserved. </p>\r\n");
      out.write("\t\t\t\t<p>&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p class=\"footer-fp-img\">\r\n");
      out.write("\t\t\t\t\t<a  href=\"#\"><img src=\"/static/img/test/kxwz.png\"></a>\r\n");
      out.write("\t\t\t\t\t<a  href=\"#\"><img src=\"/static/img/test/smyz.png\"></a>\r\n");
      out.write("\t\t\t\t\t<a  href=\"#\"><img src=\"/static/img/test/cxyz.jpg\"></a>\r\n");
      out.write("\t\t\t\t\t<a  href=\"#\"><img src=\"/static/img/test/hyyz.png\"></a>\r\n");
      out.write("\t\t\t\t\t<a  href=\"#\"><img src=\"/static/img/test/jpfw.png\"></a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 底部 _end-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/payResult.jsp(30,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.state==2}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<!-- 已过期不能支付提示 -->\r\n");
        out.write("\t\t\t<div class=\"payment-fail\">\r\n");
        out.write("\t\t\t\t<div class=\"payment-fail-con\">\r\n");
        out.write("\t\t\t\t\t<i></i>\r\n");
        out.write("\t\t\t\t\t<div class=\"payment-fail-msg\">\r\n");
        out.write("\t\t\t\t\t\t<h3 class=\"color\">支付已过期！</h3>\r\n");
        out.write("\t\t\t\t\t\t<p>您在规定的时间内未完成付款，交易自动关闭，该支付过期后不能再进行支付</p>\r\n");
        out.write("\t\t\t\t\t\t<p>\r\n");
        out.write("\t\t\t\t\t\t\t您可前往 <a href=\"http://127.0.0.1\" class=\"color\">易购网商城</a> 重新选购商品并下单。\r\n");
        out.write("\t\t\t\t\t\t</p>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t<!-- end 已过期不能支付提示 -->\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/views/payResult.jsp(46,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.state==1}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<!-- 支付成功提示 -->\r\n");
        out.write("\t\t\t<div class=\"payment-success\">\r\n");
        out.write("\t\t\t\t<div class=\"payment-success-con\">\r\n");
        out.write("\t\t\t\t\t<i></i>\r\n");
        out.write("\t\t\t\t\t<div class=\"payment-success-msg\">\r\n");
        out.write("\t\t\t\t\t\t<h3>支付成功！</h3>\r\n");
        out.write("\t\t\t\t\t\t<p>恭喜您！您的支付已成功，我们会尽快处理您的而订单业务，请随时关注您的订单通知。</p>\r\n");
        out.write("\t\t\t\t\t\t<p>\r\n");
        out.write("\t\t\t\t\t\t\t您可前往订单中心 <a href=\"http://127.0.0.1/trade/order\" class=\"color\">我的订单</a> 查看所有订单的情况，也可前往  <a href=\"http://127.0.0.1\" class=\"color\">易购网商城</a> 继续购物。\r\n");
        out.write("\t\t\t\t\t\t</p>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"payment-success-order\">\r\n");
        out.write("\t\t\t\t\t<p>以下交易单已支付成功！</p>\r\n");
        out.write("\t\t\t\t\t<div class=\"success-order-list\">\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li class=\"first\"><span class=\"transaction\"> 交易单号： <font\r\n");
        out.write("\t\t\t\t\t\t\t\t\tclass=\"color\"> <a href=\"http://127.0.0.1/trade/order/info/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write('-');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessKey}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\ttitle=\"点击查看订单\" class=\"color\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.unionPaySn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</font>\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"payable\"> 应付金额： <font class=\"color\">￥");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.money * 0.01}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</font>\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"delivery\"> 由 <font> <a\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\thref=\"#\" title=\"点击进入店铺\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\tclass=\"color\">易购网官方自营二号店</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</font> 发货\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"pay-btn\"> <a\r\n");
        out.write("\t\t\t\t\t\t\t\t\thref=\"http://127.0.0.1/trade/order/info/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write('-');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessKey}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" class=\"submit-btn\">查看订单</a>\r\n");
        out.write("\t\t\t\t\t\t\t</span></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t<!-- end 支付成功提示 -->\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/views/payResult.jsp(81,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.state==0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<!-- 支付失败提示 -->\r\n");
        out.write("\t\t\t<div class=\"payment-fail\">\r\n");
        out.write("\t\t\t\t<div class=\"payment-fail-con\">\r\n");
        out.write("\t\t\t\t\t<i></i>\r\n");
        out.write("\t\t\t\t\t<div class=\"payment-fail-msg\">\r\n");
        out.write("\t\t\t\t\t\t<h3 class=\"color\">尚未支付成功！</h3>\r\n");
        out.write("\t\t\t\t\t\t<p>如果您已付款，可能因交易量激增导致交易单延迟处理（最长数秒至数分钟）</p>\r\n");
        out.write("\t\t\t\t\t\t<p>\r\n");
        out.write("\t\t\t\t\t\t\t您可稍后 <a href=\"\" class=\"color\">刷新本页面</a> 或前往 <a\r\n");
        out.write("\t\t\t\t\t\t\t\thref=\"http://127.0.0.1/trade/order\" class=\"color\">我的订单</a> 查看支付情况\r\n");
        out.write("\t\t\t\t\t\t</p>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"payment-fail-order\">\r\n");
        out.write("\t\t\t\t\t<p>以下交易单尚未支付成功，请您尽快完成支付！</p>\r\n");
        out.write("\t\t\t\t\t<div class=\"fail-order-list\">\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li class=\"first\"><span class=\"transaction\"> 交易单号： <font\r\n");
        out.write("\t\t\t\t\t\t\t\t\tclass=\"color\"> <a href=\"http://127.0.0.1/trade/order/info/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write('-');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.businessKey}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t title=\"点击查看订单\" class=\"color\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.unionPaySn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</font>\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"payable\"> 应付金额： <font class=\"color\">￥");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.money * 0.01}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("</font>\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"delivery\"> 由 <font> <a\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\thref=\"#\" title=\"点击进入店铺\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\tclass=\"color\">易购网官方自营二号店</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</font> 发货\r\n");
        out.write("\t\t\t\t\t\t\t</span> <span class=\"pay-btn\"> <a\r\n");
        out.write("\t\t\t\t\t\t\t\t\thref=\"/gateway?sn=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payBill.unionPaySn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" class=\"submit-btn\">重新付款</a>\r\n");
        out.write("\t\t\t\t\t\t\t</span></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t<div class=\"payment-fail-reason\">\r\n");
        out.write("\t\t\t\t\t<h2>付款遇到问题了，先看看是不是由于下面的原因：</h2>\r\n");
        out.write("\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t\t<h3>所需支付金额超过了银行支付限额</h3>\r\n");
        out.write("\t\t\t\t\t\t\t<p>建议您登录网上银行提高上限额度，或是分若干次充值到您的账户余额，即能使用账户余额轻松支付。</p>\r\n");
        out.write("\t\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t\t<h3>支付宝、百度钱包或者网银页面显示错误或者空白</h3>\r\n");
        out.write("\t\t\t\t\t\t\t<p>部分网银对不同浏览器的兼容性有限，导致无法正常支付，建议您使用IE浏览器进行支付操作。</p>\r\n");
        out.write("\t\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t\t<h3>网上银行已扣款，交易单仍显示“未付款”</h3>\r\n");
        out.write("\t\t\t\t\t\t\t<p>可能由于银行的数据没有即时传输，请不要担心，请稍后刷新页面查看。如较长时间仍显示未付款，可联系客服（028-88888888）为您解决。</p>\r\n");
        out.write("\t\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t</div>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t\t<!-- end 支付失败提示 -->\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
