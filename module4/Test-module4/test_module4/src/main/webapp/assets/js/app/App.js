class App {

    static SweetAlert = class {
        static showSuspendConfirmDialog() {
            return Swal.fire({
                icon: 'warning',
                text: 'Are you sure you want to delete this product?',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Agree',
                cancelButtonText: 'Cancel',
            })
        }


        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 2500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }

    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: 3500,
                message: t
            });
        }
    }
}
class User {
    constructor(id, fullName, phone, username, password, role, status) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}

class Product {
    constructor(id, name, image, quantity, price, category, isDeleted) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.isDeleted = isDeleted;
    }
}

class Role {
    constructor(id, code) {
        this.id = id;
        this.code = code;
    }
}

class Category {
    constructor(id, category) {
        this.id = id;
        this.name = category;
    }
}
