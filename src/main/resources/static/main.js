// -------------------------------
// ADD ROW ANIMATION
// -------------------------------
function animateNewRows() {
    const newRows = document.querySelectorAll("tr[data-new='true']");

    newRows.forEach(row => {
        row.classList.add("table-row-animate");

        setTimeout(() => {
            row.classList.remove("table-row-animate");
            row.removeAttribute("data-new");
        }, 400);
    });
}



// -------------------------------
// DELETE ROW ANIMATION
// -------------------------------
function setupDeleteButtons() {
    const deleteButtons = document.querySelectorAll(".delete-btn");

    deleteButtons.forEach(btn => {
        btn.addEventListener("click", event => {
            event.preventDefault();

            const row = btn.closest("tr");
            if (!row) return;

            // Capture height for collapse animation
            const height = row.offsetHeight;
            row.style.setProperty("--row-height", height + "px");

            row.classList.add("table-row-remove");

            // Wait for animation to finish
            setTimeout(() => {
                // Submit the delete form or trigger your Spring action
                const form = btn.closest("form");
                if (form) form.submit();
            }, 350);
        });
    });
}



// -------------------------------
// ADD ROW BUTTONS (Spring handles actual add)
// -------------------------------
function setupAddRowButtons() {
    const addButtons = document.querySelectorAll(".add-row-btn");

    addButtons.forEach(btn => {
        btn.addEventListener("click", event => {
            event.preventDefault();

            // Submit the form that triggers Spring to add a row
            const form = btn.closest("form");
            if (form) form.submit();
        });
    });
}



// -------------------------------
// INITIALIZE EVERYTHING
// -------------------------------
document.addEventListener("DOMContentLoaded", () => {
    setupDeleteButtons();
    setupAddRowButtons();
    animateNewRows();
});