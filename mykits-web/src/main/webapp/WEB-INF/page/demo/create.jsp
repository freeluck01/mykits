<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div>
        <div>
            <h3>Demo新增</h3>
            <div>
                <p><i></i>请填写Demo信息，谢谢</p>
                <form action="/demo/save" id="form" method="post">
                    <dl>
                        <dt><i></i>姓名：</dt>
                        <dd><input type="text" id="name" name="name" placeholder="请输入姓名" class="validate" /><span>*请输入姓名</span></dd>
                    </dl>
                    <dl>
                        <dt><i></i>ERP：</dt>
                        <dd><input type="text" id="erp" name="erp" placeholder="请输入您的ERP" class="validate" /><span>*请输入您的ERP</span></dd>
                    </dl>
                    <dl>
                        <dt><i></i>phone：</dt>
                        <dd><input type="text" id="phone" name="phone" placeholder="请输入您的phone" class="validate" /><span>*请输入您的phone</span></dd>
                    </dl>
                    <dl>
                        <dt><i></i>email：</dt>
                        <dd><input type="text" id="email" name="email" placeholder="请输入您的email" class="validate" /><span>*请输入您的email</span></dd>
                    </dl>
                    <dl>
                        <dt><i></i>orgid：</dt>
                        <dd><input type="text" id="orgid" name="orgid" placeholder="请输入您的orgid" class="validate" /><span>*请输入您的orgid</span></dd>
                    </dl>
                    <dl>
                        <dt><i></i>depart：</dt>
                        <dd><input type="text" id="depart" name="depart" placeholder="请输入您的depart" class="validate" /><span>*请输入您的depart</span></dd>
                    </dl>

                    <input type="submit" value="提交">
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(function(){
        $("#submit_btn").click(function (){
            $("#form").submit();
        });
    });

</script>