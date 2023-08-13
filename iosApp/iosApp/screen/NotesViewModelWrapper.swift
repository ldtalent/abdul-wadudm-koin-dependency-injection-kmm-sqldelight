
import Foundation
import shared


final class NotesViewModelWrapper : ObservableObject{
    let notesViewModel : NotesViewModel = Koin.instance.get()
}
