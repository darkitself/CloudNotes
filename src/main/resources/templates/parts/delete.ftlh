<#macro delete path id role>
    <#if role == 'OWNER'>
        <form action="${path}/${id}" method="post">
            <input type="submit" value="Delete"/>
        </form>
    </#if>
</#macro>