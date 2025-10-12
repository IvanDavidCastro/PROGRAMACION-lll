from tkinter import *

class FrmPanelControl(Toplevel):
    def __init__(self, datos):
        super().__init__()
        self.title("Panel de Control - Tecnar App")
        self.geometry("500x300")

        self.config(bg="Cyan")

        nombre, apellido, email, username, rol = datos

        lbl_titulo = Label(self, text="Panel de Control", font=("Arial", 14, "bold"), bg="lightgray")
        lbl_titulo.grid(row=0, column=0, columnspan=2, pady=10)

        Label(self, text="Nombre:", font=("Arial", 12, "bold"), bg="lightgray").grid(row=1, column=0, sticky="e", padx=10, pady=5)
        Label(self, text=f"{nombre} {apellido}", font=("Arial", 12), bg="lightgray").grid(row=1, column=1, sticky="w", padx=10, pady=5)

        Label(self, text="Email:", font=("Arial", 12, "bold"), bg="lightgray").grid(row=2, column=0, sticky="e", padx=10, pady=5)
        Label(self, text=email, font=("Arial", 12), bg="lightgray").grid(row=2, column=1, sticky="w", padx=10, pady=5)

        Label(self, text="Usuario:", font=("Arial", 12, "bold"), bg="lightgray").grid(row=3, column=0, sticky="e", padx=10, pady=5)
        Label(self, text=username, font=("Arial", 12), bg="lightgray").grid(row=3, column=1, sticky="w", padx=10, pady=5)

        Label(self, text="Rol:", font=("Arial", 12, "bold"), bg="lightgray").grid(row=4, column=0, sticky="e", padx=10, pady=5)
        Label(self, text=rol, font=("Arial", 12), bg="lightgray", fg="green").grid(row=4, column=1, sticky="w", padx=10, pady=5)

        Button(self, text="Cerrar", command=self.destroy).grid(row=5, column=0, columnspan=2, pady=15)