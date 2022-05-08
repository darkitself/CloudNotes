<#import "../parts/common.ftlh" as c>
<#import "../parts/delete.ftlh" as d>
<@c.page>
    <a href="/api/note/create">Create note</a>
    <div>Notes</div>
    <#list response.getUserNotes() as note>
        <div>
            <a href="/api/note/${note.getId()}"><b>${note.getName()}</b></a> <@d.delete "/api/note/delete" "${note.getId()}" "OWNER"/>
        </div>
        <br>
    </#list>

</@c.page>