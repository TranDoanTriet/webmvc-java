
function addToCart() {
	
	var quantity = parseInt(document.getElementById("quantity").value);
	var currentItemCount = parseInt(document.getElementById("cart-item-count").innerText);
	var newItemCount = currentItemCount + quantity;
	document.getElementById("cart-item-count").innerText = newItemCount;
    // Tạo một phần tử div để hiển thị thông báo
   /*const notification = document.createElement('div');
    notification.className = 'alert alert-success alert-dismissible fade show';
    notification.role = 'alert';
    notification.innerHTML = `
        Added to cart successfully!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    `;

    // Thêm thông báo vào container
    const container = document.getElementById('notification-container');
    container.appendChild(notification);

    // Loại bỏ thông báo sau 3 giây
    setTimeout(() => {
        notification.classList.remove('show');
        notification.classList.add('fade');
        setTimeout(() => {
            container.removeChild(notification);
        }, 500); // Đợi 500ms để hiệu ứng fade out hoàn tất
    }, 3000);*/
}