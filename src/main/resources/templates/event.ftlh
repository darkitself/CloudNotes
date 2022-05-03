<#import "parts/common.ftlh" as c>

<@c.page>
    <a href="/api/events/create">Create event</a>
    <div>Events list</div>
    <#list response.getUserEvents() as res>
        <div>
            <a href="/api/events/${res.getEventId()}"><b>${res.getName()}</b></a> <p>${res.getDate()}</p>
            <br>
        </div>
    </#list>
</@c.page>