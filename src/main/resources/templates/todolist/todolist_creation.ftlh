<#import "../parts/common.ftlh" as c>

<@c.page>
    <form action="/api/todolist/create" method="post">
        <div><label> Name : <input type="text" name="name"/> </label></div>
        <div>
            <label>
                <select name="eventId">
                    <option value="" label="none"></option>
                    <#list events as id,name>
                        <option value="${id}">${name}</option>
                    </#list>
                </select>
            </label>
        </div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>