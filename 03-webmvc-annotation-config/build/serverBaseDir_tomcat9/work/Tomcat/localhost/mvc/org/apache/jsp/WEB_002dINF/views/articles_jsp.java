/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.34
 * Generated at: 2020-11-30 00:17:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class articles_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent,
        org.apache.jasper.runtime.JspSourceImports {

    private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

    static {
        _jspx_fnmap_0 = org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[]{java.lang.Object.class});
    }

    private static final javax.servlet.jsp.JspFactory _jspxFactory =
            javax.servlet.jsp.JspFactory.getDefaultFactory();

    private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;

    static {
        _jspx_dependants = new java.util.HashMap<java.lang.String, java.lang.Long>(6);
        _jspx_dependants.put("jar:file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153374282000L));
        _jspx_dependants.put("jar:file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153374282000L));
        _jspx_dependants.put("file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar", Long.valueOf(1606597306000L));
        _jspx_dependants.put("jar:file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/org.springframework/spring-webmvc/5.2.9.RELEASE/bec8682df7622707f067f98457ee95a8f276de80/spring-webmvc-5.2.9.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1600147332000L));
        _jspx_dependants.put("file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/org.springframework/spring-webmvc/5.2.9.RELEASE/bec8682df7622707f067f98457ee95a8f276de80/spring-webmvc-5.2.9.RELEASE.jar", Long.valueOf(1606597306000L));
        _jspx_dependants.put("jar:file:/Users/theodorevezenkov/.gradle/caches/modules-2/files-2.1/javax.servlet/jstl/1.2/74aca283cd4f4b4f3e425f5820cda58f44409547/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    }

    private static final java.util.Set<java.lang.String> _jspx_imports_packages;

    private static final java.util.Set<java.lang.String> _jspx_imports_classes;

    static {
        _jspx_imports_packages = new java.util.HashSet<>();
        _jspx_imports_packages.add("javax.servlet");
        _jspx_imports_packages.add("javax.servlet.http");
        _jspx_imports_packages.add("javax.servlet.jsp");
        _jspx_imports_classes = null;
    }

    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;
    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

    private volatile javax.el.ExpressionFactory _el_expressionfactory;
    private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

    public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
        return _jspx_dependants;
    }

    public java.util.Set<java.lang.String> getPackageImports() {
        return _jspx_imports_packages;
    }

    public java.util.Set<java.lang.String> getClassImports() {
        return _jspx_imports_classes;
    }

    public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
        if (_el_expressionfactory == null) {
            synchronized (this) {
                if (_el_expressionfactory == null) {
                    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
                }
            }
        }
        return _el_expressionfactory;
    }

    public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
        if (_jsp_instancemanager == null) {
            synchronized (this) {
                if (_jsp_instancemanager == null) {
                    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
                }
            }
        }
        return _jsp_instancemanager;
    }

    public void _jspInit() {
        _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    }

    public void _jspDestroy() {
        _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
        _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
    }

    public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
            throws java.io.IOException, javax.servlet.ServletException {

        if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
            final java.lang.String _jspx_method = request.getMethod();
            if ("OPTIONS".equals(_jspx_method)) {
                response.setHeader("Allow", "GET, HEAD, POST, OPTIONS");
                return;
            }
            if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
                response.setHeader("Allow", "GET, HEAD, POST, OPTIONS");
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
                return;
            }
        }

        final javax.servlet.jsp.PageContext pageContext;
        javax.servlet.http.HttpSession session = null;
        final javax.servlet.ServletContext application;
        final javax.servlet.ServletConfig config;
        javax.servlet.jsp.JspWriter out = null;
        final java.lang.Object page = this;
        javax.servlet.jsp.JspWriter _jspx_out = null;
        javax.servlet.jsp.PageContext _jspx_page_context = null;


        try {
            response.setContentType("text/html");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;

            out.write("<!DOCTYPE html>\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("<html lang=\"en\">\n");
            out.write("<head>\n");
            out.write("\n");
            out.write("    <!-- Access the bootstrap Css like this,\n");
            out.write("        Spring boot will handle the resource mapping automcatically -->\n");
            out.write("    ");
            if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
                return;
            out.write("\n");
            out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bootstrapCss}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
            out.write("\" />\n");
            out.write("\n");
            out.write('\n');
            out.write("\n");
            out.write("    ");
            if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
                return;
            out.write("\n");
            out.write("    <link href=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mainCss}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
            out.write("\" rel=\"stylesheet\" />\n");
            out.write("    <title>Spring MVC Demo</title>\n");
            out.write("\n");
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("\n");
            out.write("<nav class=\"navbar navbar-inverse\">\n");
            out.write("    <div class=\"container\">\n");
            out.write("        <div class=\"navbar-header\">\n");
            out.write("            <a class=\"navbar-brand\" href=\"#\">Spring Boot</a>\n");
            out.write("        </div>\n");
            out.write("        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
            out.write("            <ul class=\"nav navbar-nav\">\n");
            out.write("                <li class=\"active\"><a href=\"#\">Home</a></li>\n");
            out.write("                <li><a href=\"#about\">About</a></li>\n");
            out.write("            </ul>\n");
            out.write("        </div>\n");
            out.write("    </div>\n");
            out.write("</nav>\n");
            out.write("\n");
            out.write("<div class=\"container\">\n");
            out.write("\n");
            out.write("    <div class=\"starter-template\">\n");
            out.write("        <h1>Spring Boot Web JSP Example</h1>\n");
            out.write("        <h2>\n");
            out.write("            ");
            if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
                return;
            out.write("\n");
            out.write("\n");
            out.write("            ");
            if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
                return;
            out.write("\n");
            out.write("        </h2>\n");
            out.write("\n");
            out.write("        <h2>Articles count: ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(articles)}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, _jspx_fnmap_0));
            out.write(" </h2>\n");
            out.write("        <table class=\"article-table\">\n");
            out.write("            <thead>\n");
            out.write("            <tr>\n");
            out.write("                <th>Number</th>\n");
            out.write("                <th>Title</th>\n");
            out.write("                <th>Content</th>\n");
            out.write("                <th>Date</th>\n");
            out.write("            </tr>\n");
            out.write("            </thead>\n");
            out.write("            <tbody>\n");
            out.write("            ");
            if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
                return;
            out.write("\n");
            out.write("            </tbody>\n");
            out.write("        </table>\n");
            out.write("\n");
            out.write("    </div>\n");
            out.write("\n");
            out.write("    <div class=\"buttons\">\n");
            out.write("        <a class=\"btn btn-primary\" href=\"new-article\">Add New Article</a>\n");
            out.write("    </div>\n");
            out.write("\n");
            out.write("</div>\n");
            out.write("\n");
            if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
                return;
            out.write("\n");
            out.write("<script type=\"text/javascript\" src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jquery}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
            out.write("\"></script>\n");
            if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
                return;
            out.write("\n");
            out.write("<script type=\"text/javascript\" src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bootstrapJS}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
            out.write("\"></script>\n");
            out.write("</body>\n");
            out.write("\n");
            out.write("</html>");
        } catch (java.lang.Throwable t) {
            if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    try {
                        if (response.isCommitted()) {
                            out.flush();
                        } else {
                            out.clearBuffer();
                        }
                    } catch (java.io.IOException e) {
                    }
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
                else throw new ServletException(t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }

    private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:url
        org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
        boolean _jspx_th_c_005furl_005f0_reused = false;
        try {
            _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
            _jspx_th_c_005furl_005f0.setParent(null);
            // /WEB-INF/views/articles.jsp(11,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f0.setValue("/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css");
            // /WEB-INF/views/articles.jsp(11,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f0.setVar("bootstrapCss");
            int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
            if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
            _jspx_th_c_005furl_005f0_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:url
        org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
        boolean _jspx_th_c_005furl_005f1_reused = false;
        try {
            _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
            _jspx_th_c_005furl_005f1.setParent(null);
            // /WEB-INF/views/articles.jsp(16,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f1.setValue("/resources/css/main.css");
            // /WEB-INF/views/articles.jsp(16,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f1.setVar("mainCss");
            int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
            if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
            _jspx_th_c_005furl_005f1_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:if
        org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
        boolean _jspx_th_c_005fif_005f0_reused = false;
        try {
            _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f0.setParent(null);
            // /WEB-INF/views/articles.jsp(42,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty name}", boolean.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null)).booleanValue());
            int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
            if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                    out.write("\n");
                    out.write("                Hello ");
                    out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
                    out.write("\n");
                    out.write("            ");
                    int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                } while (true);
            }
            if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
            _jspx_th_c_005fif_005f0_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:if
        org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
        boolean _jspx_th_c_005fif_005f1_reused = false;
        try {
            _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f1.setParent(null);
            // /WEB-INF/views/articles.jsp(46,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty name}", boolean.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null)).booleanValue());
            int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
            if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                    out.write("\n");
                    out.write("                Welcome Spring User!\n");
                    out.write("            ");
                    int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                } while (true);
            }
            if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
            _jspx_th_c_005fif_005f1_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:forEach
        org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
        boolean _jspx_th_c_005fforEach_005f0_reused = false;
        try {
            _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
            _jspx_th_c_005fforEach_005f0.setParent(null);
            // /WEB-INF/views/articles.jsp(62,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f0.setVar("article");
            // /WEB-INF/views/articles.jsp(62,12) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f0.setVarStatus("status");
            // /WEB-INF/views/articles.jsp(62,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/articles.jsp(62,12) '${articles}'", _jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(), "${articles}", java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
            int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[]{0};
            try {
                int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
                if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                        out.write("\n");
                        out.write("                <tr>\n");
                        out.write("                    <td>");
                        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.index}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
                        out.write("</td>\n");
                        out.write("                    <td>");
                        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.title}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
                        out.write("</td>\n");
                        out.write("                    <td>");
                        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.content}", java.lang.String.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
                        out.write("</td>\n");
                        out.write("                    <td>");
                        if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
                            return true;
                        out.write("</td>\n");
                        out.write("                </tr>\n");
                        out.write("            ");
                        int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
                        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                    } while (true);
                }
                if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    return true;
                }
            } catch (java.lang.Throwable _jspx_exception) {
                while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
                    out = _jspx_page_context.popBody();
                _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
            } finally {
                _jspx_th_c_005fforEach_005f0.doFinally();
            }
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
            _jspx_th_c_005fforEach_005f0_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
        }
        return false;
    }

    private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  fmt:formatDate
        org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
        boolean _jspx_th_fmt_005fformatDate_005f0_reused = false;
        try {
            _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
            _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
            // /WEB-INF/views/articles.jsp(67,24) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_fmt_005fformatDate_005f0.setPattern("dd.MM.yyyy");
            // /WEB-INF/views/articles.jsp(67,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.createdDate}", java.util.Date.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null));
            int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
            if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
            _jspx_th_fmt_005fformatDate_005f0_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatDate_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatDate_005f0_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:url
        org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
        boolean _jspx_th_c_005furl_005f2_reused = false;
        try {
            _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
            _jspx_th_c_005furl_005f2.setParent(null);
            // /WEB-INF/views/articles.jsp(81,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f2.setValue("/webjars/jquery/3.1.1/jquery.min.js");
            // /WEB-INF/views/articles.jsp(81,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f2.setVar("jquery");
            int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
            if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
            _jspx_th_c_005furl_005f2_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
        }
        return false;
    }

    private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:url
        org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
        boolean _jspx_th_c_005furl_005f3_reused = false;
        try {
            _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
            _jspx_th_c_005furl_005f3.setParent(null);
            // /WEB-INF/views/articles.jsp(83,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f3.setValue("/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js");
            // /WEB-INF/views/articles.jsp(83,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005furl_005f3.setVar("bootstrapJS");
            int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
            if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return true;
            }
            _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
            _jspx_th_c_005furl_005f3_reused = true;
        } finally {
            org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f3, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f3_reused);
        }
        return false;
    }
}
