
import SwiftUI

struct NotesScreen: View {
    
    @StateObject private var viewModelWrapper  = AboutViewModelWrapper()
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

struct NotesScreen_Previews: PreviewProvider {
    static var previews: some View {
        NotesScreen()
    }
}
