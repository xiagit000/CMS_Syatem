<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>500 error</title>
<style type="text/css">
.error {
  width: 800px;
  margin: 0 auto;
  margin-top: 150px;
  height: 220px;
  border: 3px #2B85CF dashed;
  background: #9ED6ED;
  padding: 50px;
}

.error p {
  font-size: 36px;
  margin-top: 30px;
  color: #000;
}

.error h2 {
  font-size: 36px;
  font-weight: 600;
  color: #FF3300;
  border-bottom: 2px #2B85CF solid;
  padding: 3px;
  float: none;
  margin-top: 20px;
  padding-bottom: 30px;
}

h2.hei {
  color: #000;
}
</style>
</head>
<body>
    <div class="error">
        <h2>500 error!</h2>
        <p>系统出现未知错误，请与管理员联系......</p>
    </div>

      
</body>
</html>