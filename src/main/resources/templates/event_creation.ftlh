<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/api/events/create" method="post">
        <div><label> Name : <input type="text" name="name"/> </label></div>
        <div><label> Datetime: <input type="datetime-local" name="date"/> </label></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>