$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
     hasToggle = $("#wrapper").hasClass("toggled");
    if(hasToggle) {
        $("#sidebardesc").text("Open Sidebar Menu")
    } else {
        $("#sidebardesc").text("Close Sidebar Menu")
    }
});