<#import "../parts/common.ftlh" as c>
<#import "../parts/delete.ftlh" as d>
<@c.page>
    <a href="/api/notes/create">Create note</a>
    <div>Note list</div>
    <#list response.getUserNotes() as note>
        <div>
            <a href="/api/notes/${note.getId()}"><b>${note.getName()}</b></a> <@d.delete "/api/notes/delete" "${note.getId()}" "${note.getRole()}"/>
        </div>
        <br>
    </#list>

</@c.page>